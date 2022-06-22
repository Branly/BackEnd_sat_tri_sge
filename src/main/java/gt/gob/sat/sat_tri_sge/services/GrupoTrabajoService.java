/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.services;

import gt.gob.sat.arquitectura.microservices.config.request.Detector;
import gt.gob.sat.sat_tri_sge.dtos.GrupotrabajoDTO;
import gt.gob.sat.sat_tri_sge.dtos.IntegranteGurpoDTO;
import gt.gob.sat.sat_tri_sge.models.SgeColaborador;
import gt.gob.sat.sat_tri_sge.models.SgeGrupoTrabjo;
import gt.gob.sat.sat_tri_sge.models.SgeIntegranteGrupo;
import gt.gob.sat.sat_tri_sge.models.SgeIntegranteGrupoId;
import gt.gob.sat.sat_tri_sge.repositories.GrupoTrabajoRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import gt.gob.sat.sat_tri_sge.projections.GrupoTrabajoProjection;
import gt.gob.sat.sat_tri_sge.repositories.ColaboradorRepository;
import gt.gob.sat.sat_tri_sge.repositories.IntegranteGrupoRepository;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author crist
 */
@Transactional
@Service
@Slf4j

public class GrupoTrabajoService {

    @Autowired
    private GrupoTrabajoRepository grupoTrabajoRepository;

    @Autowired
    private IntegranteGrupoRepository integranteGrupoRepository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private Detector detector;

    /**
     * Metodo para obtener grupos de trabajo
     *
     * @author Cristian Raguay (acdraguay)
     * @since 13/06/2022
     * @return Grupos
     */
    @Transactional(readOnly = true)
    public List<GrupoTrabajoProjection> getGroups() {
        log.debug("Obteniene los grupos");
        return grupoTrabajoRepository.Grupos();
    }

    /**
     * Metodo para crear grupos de trabajo
     *
     * @author Cristian Raguay (acdraguay)
     * @since 13/06/2022
     * @return grupoTrabajo
     */
    @Transactional
    public SgeGrupoTrabjo createGroup(GrupotrabajoDTO dto) {
        final SgeGrupoTrabjo grupoTrabajo = new SgeGrupoTrabjo();
        grupoTrabajo.setEstado(dto.getEstado());
        grupoTrabajo.setFechaModifica(dto.getFechaModifica());
        grupoTrabajo.setIpModifica(dto.getIpModifica());
        grupoTrabajo.setNitEncargado(dto.getNitEncargado());
        grupoTrabajo.setNombre(dto.getNombre());
        grupoTrabajo.setUsuarioModifica(dto.getUsuarioModifica());
        return grupoTrabajoRepository.save(grupoTrabajo);
    }

    /**
     * Metodo para eliminar Grupos
     *
     * @author Cristian Raguay (acdraguay)
     * @since 13/06/2022
     * @return groupDelete
     */
    @Transactional
    public SgeGrupoTrabjo deletGroup(int id) {
        final SgeGrupoTrabjo groupDelete = grupoTrabajoRepository.findById(id).orElse(null);
        groupDelete.setEstado(12);
        return groupDelete;
    }

    /**
     * Metodo para actualizar grupos de trabajo
     *
     * @author Cristian Raguay (acdraguay)
     * @since 13/06/2022
     * @return groupUpdate
     */
    @Transactional
    public SgeGrupoTrabjo updateGoup(int id, GrupotrabajoDTO dto) {
        final SgeGrupoTrabjo groupUpdate = grupoTrabajoRepository.findById(id).orElse(null);
        groupUpdate.setEstado(dto.getEstado());
        groupUpdate.setNitEncargado(dto.getNitEncargado());
        return grupoTrabajoRepository.save(groupUpdate);
    }

    /**
     * Metodo para agregar un nuevo meiembro
     *
     * @author Cristian Raguay (acdraguay)
     * @param dto
     * @since 14/06/2022
     * @return createMember
     */
    @Transactional
    public SgeIntegranteGrupo createMemberGroup(IntegranteGurpoDTO dto) {
        final SgeIntegranteGrupo createMember = new SgeIntegranteGrupo();
        createMember.setFechaModifica(new Date());
        createMember.setId(new SgeIntegranteGrupoId(dto.getIdGrupo(), dto.getNitProfecional()));
        createMember.setIpModifica(detector.getIp());
        createMember.setUsuarioModifica(detector.getLogin());
        createMember.setNitSupervisor(dto.getNitSupervisor());
        return integranteGrupoRepository.save(createMember);
    }
    
    /**
     * Metodo para actualizar un miembro del grupo
     *
     * @author Cristian Raguay (acdraguay)
     * @param dto
     * @since 16/06/2022
     * @return boolean
     */
    @Transactional
    public boolean updateMemberGroup(IntegranteGurpoDTO dto) {
        final SgeIntegranteGrupo updateMember = new SgeIntegranteGrupo();
        final SgeIntegranteGrupo member = integranteGrupoRepository.findById(new SgeIntegranteGrupoId(dto.getIdGrupo(), dto.getNitProfecional())).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Grupo no encontrado."));
        if (member != null) {
            integranteGrupoRepository.deleteById(new SgeIntegranteGrupoId(dto.getIdGrupo(), dto.getNitProfecional()));
            this.createMemberGroup(dto);
            return true;
        }

        return false;
    }

    /**
     * Metodo para eliminar a un miembro del grupo
     *
     * @author Cristian Raguay (acdraguay)
     * @param dto
     * @since 16/06/2022
     */
    @Transactional
    public void deleteMember(IntegranteGurpoDTO dto) {
        final SgeIntegranteGrupo member = integranteGrupoRepository.findById(new SgeIntegranteGrupoId(dto.getIdGrupo(), dto.getNitProfecional())).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Grupo no encontrado."));
        integranteGrupoRepository.deleteById(new SgeIntegranteGrupoId(dto.getIdGrupo(), dto.getNitProfecional()));
    }

}
