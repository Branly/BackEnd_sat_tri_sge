 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.services;

import gt.gob.sat.arquitectura.microservices.config.request.Detector;
import gt.gob.sat.sat_tri_sge.dtos.BitacoraAsignacionColaboradorDTO;
import gt.gob.sat.sat_tri_sge.dtos.ColaboradorDTO;
import gt.gob.sat.sat_tri_sge.dtos.HistorialEstadosColaboradorDTO;
import gt.gob.sat.sat_tri_sge.repositories.ColaboradorPerfilRepository;
import gt.gob.sat.sat_tri_sge.models.SgeBitacoraAsignacionColaborador;
import gt.gob.sat.sat_tri_sge.models.SgeColaborador;
import gt.gob.sat.sat_tri_sge.models.SgeColaboradorPerfil;
import gt.gob.sat.sat_tri_sge.models.SgeColaboradorPerfilId;
import gt.gob.sat.sat_tri_sge.models.SgeHistorialEstadosColaborador;
import gt.gob.sat.sat_tri_sge.repositories.ColaboradorRepository;
import gt.gob.sat.sat_tri_sge.repositories.HistorialEstadosColaboradorRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import gt.gob.sat.sat_tri_sge.projections.ColaboradorProjection;
import gt.gob.sat.sat_tri_sge.projections.SupervisorProjection;
import gt.gob.sat.sat_tri_sge.repositories.BitacoraAsignacionColaboradorRepository;
import java.util.Date;

/**
 *
 * @author crist
 */
@Transactional
@Service
@Slf4j
  
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private HistorialEstadosColaboradorRepository historialEstadosColaboradorRepository;

    @Autowired
    private Detector detector;

    @Autowired
    private BitacoraAsignacionColaboradorRepository bitacoraAsignacionColaboradorRepository;
    
   @Autowired
   private ColaboradorPerfilRepository colaboradorPerfilRepository;

    /**
     * Metodo para mostrar un colaborador en base a su nit
     *
     * @author Cristian Raguay (acdraguay)
     * @param nit
     * @since 10/06/2022
     * @return Colaborador
     */
    @Transactional(readOnly = true)
    public List<ColaboradorProjection> getColaborator(String nit) {
        log.debug("Obteniendo un coloborador");
        return colaboradorRepository.Colaborador(nit);
    }

    /**
     * Metodo para Crear un colaborador
     *
     * @author Cristian Raguay (acdraguay)
     * @param dto
     * @since 10/06/2022
     * @return true
     */
    @Transactional
    public boolean CreateColaborator(ColaboradorDTO dto) {
        final SgeColaborador colaborator = new SgeColaborador();
        final SgeColaboradorPerfil rol = new SgeColaboradorPerfil();
        colaborator.setNit(dto.getNit());
        colaborator.setNombre(dto.getNombre());
        colaborator.setCargaTrabajo(dto.getCargaTrabajo());
        colaborator.setCorreo(dto.getCorreo());
        colaborator.setIdEstado(dto.getIdEstado());
        colaborator.setTipoTributa(dto.getTipoTributa());
        colaborator.setUsuarioModifica(dto.getUsuarioModifica());
        colaborator.setFechaModifica(dto.getFechaModifica());
        colaborator.setIpModifica(dto.getIpModifica());
        colaborator.setIniciales(dto.getIniciales());
        colaborator.setLogin(dto.getLogin());
        colaborator.setPuestoTrabajo(dto.getPuestoTrabajo());
        colaborator.setIdGerencia(dto.getIdGerencia());
        rol.setId(new SgeColaboradorPerfilId(dto.getRol(), dto.getNit()));
        rol.setEstado(1);
        final SgeHistorialEstadosColaborador history = new SgeHistorialEstadosColaborador();
        history.setFechaModifica(dto.getFechaModifica());
        history.setIdEstado(dto.getIdEstado());
        history.setIpModifica(dto.getIpModifica());
        history.setNitColaborador(dto.getNit());
        history.setUsuarioModifica(dto.getUsuarioModifica());
        colaboradorPerfilRepository.save(rol);
        colaboradorRepository.save(colaborator);
        historialEstadosColaboradorRepository.save(history);
        return true;
    }

    /**
     * Metodo para Crear un colaborador
     *
     * @author Cristian Raguay (acdraguay)
     * @param nit
     * @param dto
     * @since 10/06/2022
     * @return colaborator
     */
    @Transactional
    public SgeColaborador PutColaborador(String nit, ColaboradorDTO dto) {
        final SgeColaborador colaboratorPut = colaboradorRepository.findById(nit).orElse(null);
        colaboratorPut.setIdEstado(dto.getIdEstado());
        colaboratorPut.setCorreo(dto.getCorreo());
        colaboratorPut.setTipoTributa(dto.getTipoTributa());
        final SgeHistorialEstadosColaborador history = new SgeHistorialEstadosColaborador();
        history.setFechaModifica(dto.getFechaModifica());
        history.setIdEstado(dto.getIdEstado());
        history.setIpModifica(dto.getIpModifica());
        history.setNitColaborador(dto.getNit());
        history.setUsuarioModifica(dto.getUsuarioModifica());
        historialEstadosColaboradorRepository.save(history);
        return colaboratorPut;
    }

    /**
     * Metodo de Eliminacion logica de un colaborador
     *
     * @author Cristian Raguay (acdraguay)
     * @param nit
     * @param dto
     * @since 10/06/2022
     * @return colaboradorDelete
     */
    @Transactional
    public SgeColaborador DeleteColaborador(String nit, HistorialEstadosColaboradorDTO dto) {
        final SgeColaborador colaboratorDelete = colaboradorRepository.findById(nit).orElse(null);
        colaboratorDelete.setIdEstado(2);
        this.CreateHistory(dto);
        return colaboratorDelete;
    }

    /**
     * Metodo para Crear un historial de estados del colaborador
     *
     * @author Cristian Raguay (acdraguay)
     * @param dto
     * @since 10/06/2022
     * @return historyCreate
     */
    @Transactional
    public SgeHistorialEstadosColaborador CreateHistory(HistorialEstadosColaboradorDTO dto) {
        final SgeHistorialEstadosColaborador historyCreate = new SgeHistorialEstadosColaborador();
        historyCreate.setFechaModifica(new Date());
        historyCreate.setIdEstado(dto.getIdEstado());
        historyCreate.setIpModifica(detector.getIp());
        historyCreate.setNitColaborador(dto.getNitColaborador());
        historyCreate.setUsuarioModifica(detector.getLogin());
        return historialEstadosColaboradorRepository.save(historyCreate);
    }

    /**
     * Metodo para crear la bitacora de asignaciones de Colaborador
     *
     * @author Cristian Raguay (acdraguay)
     * @param dto
     * @since 14/06/2022
     * @return historyAssignment
     */
    @Transactional
    public SgeBitacoraAsignacionColaborador createHistoryAssignmentCollaborator(BitacoraAsignacionColaboradorDTO dto) {
        final SgeBitacoraAsignacionColaborador historyAssignment = new SgeBitacoraAsignacionColaborador();
        historyAssignment.setComentario(dto.getComentario());
        historyAssignment.setFechaModifica(new Date());
        historyAssignment.setIdEstado(dto.getIdEstado());
        historyAssignment.setIpModifica(detector.getIp());
        historyAssignment.setNit(dto.getNit());
        historyAssignment.setNoExpedienteTributa(dto.getNoExpedienteTributa());
        historyAssignment.setUsuarioModifica(detector.getLogin());
        return bitacoraAsignacionColaboradorRepository.save(historyAssignment);
    }

    /**
     * Metodo para crear la bitacora de asignaciones de Colaborador
     *
     * @author Cristian Raguay (acdraguay)
     * @param puesto
     * @since 22/06/2022
     * @return CollaboratorRole
     */
    @Transactional(readOnly = true)
    public List<ColaboradorProjection> CollaboratorRol(int rol, int tipo) {
        return colaboradorRepository.collaboratorsRol(rol, tipo);
    }

    @Transactional(readOnly = true)
    public List<ColaboradorProjection> CollaboratorType(int rol, String tipo) {
        return colaboradorRepository.collaboratorType(rol, tipo);
    }

    @Transactional(readOnly = true)
    public String centralizer(int rol) {
        return colaboradorRepository.Centralizer(rol);
    }

    @Transactional(readOnly = true)
    public String collaboratorSupervisor(String nit) {
        return colaboradorRepository.collaboratorSupervisor(nit);
    }

    @Transactional(readOnly = true)
    public String collaboratorSpecialist(String nit) {
        return colaboradorRepository.collaboratorSpecialist(nit);
    }

    @Transactional(readOnly = true)
    public List<ColaboradorProjection> collaboratorNotGroup(int puesto, int tipo) {
        return colaboradorRepository.collaboratorNotGroup(puesto, tipo);
    }

    @Transactional(readOnly = true)
    public List<SupervisorProjection> supervisorGroup(int grupo) {
        return colaboradorRepository.supervisorGroup(grupo);
    }

    @Transactional(readOnly = true)
    public List<SupervisorProjection> professionalGroup(String nit) {
        return colaboradorRepository.propfessionalGroup(nit);
    }
}
