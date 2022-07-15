/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.services;

import gt.gob.sat.arquitectura.microservices.config.request.Detector;
import gt.gob.sat.sat_tri_sge.dtos.ExpedienteProvidenciaDTO;
import gt.gob.sat.sat_tri_sge.dtos.ProvidenciaDTO;
import gt.gob.sat.sat_tri_sge.models.SgeExpedienteProvidencia;
import gt.gob.sat.sat_tri_sge.models.SgeExpedienteProvidenciaId;
import gt.gob.sat.sat_tri_sge.models.SgeProvidencia;
import gt.gob.sat.sat_tri_sge.repositories.ExpedienteProvidenciaRepitory;
import gt.gob.sat.sat_tri_sge.repositories.ProvidenciaRepository;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author crist
 */

@Transactional
@Service
@Slf4j

public class ProvidenciaService {
    
    
    @Autowired
    private ProvidenciaRepository providenciaRepository;
    @Autowired
    private ExpedienteProvidenciaRepitory expedienteProvidenciaRepository;
    @Autowired
    private Detector detector;

    /**
     * Metodo para crear una providencia
     *
     * @author Gabriel runao (agaruanom)
     * @param dto ProvidenciaDto
     * @since 15/06/2022
     * @return newProvidence
     */
    @Transactional
    public SgeProvidencia createProvidence(ProvidenciaDTO dto) {
        final SgeProvidencia newProvidence = new SgeProvidencia();
        newProvidence.setIdProvidencia(dto.getIdProvidencia());
        newProvidence.setFechaCreacion(dto.getFechaCreacion());
        newProvidence.setTipoProvidencia(dto.getTipoProvidencia());
        newProvidence.setFechaModifica(new Date());
        newProvidence.setUsuarioModifica(detector.getLogin());
        newProvidence.setIpModifica(detector.getIp());
        return providenciaRepository.save(newProvidence);
    }

    /**
     * Metodo para asignar una providencia de salida a un expediente
     *
     * @author Gabriel runao (agaruanom)
     * @param dto ExpedienteProvidenciaDto
     * @since 15/06/2022
     * @return newcreateFileProvidence
     */
    @Transactional
    public SgeExpedienteProvidencia createFileProvidence(ExpedienteProvidenciaDTO dto) {
        final SgeExpedienteProvidencia newcreateFileProvidence = new SgeExpedienteProvidencia();
        newcreateFileProvidence.setId(new SgeExpedienteProvidenciaId(dto.getIdProvidencia(), dto.getNoexpediente()));
        newcreateFileProvidence.setComentario(dto.getComentario());
        newcreateFileProvidence.setResolucion(dto.getResolucion());
        newcreateFileProvidence.setFechaModifica(new Date());
        newcreateFileProvidence.setUsuarioModifica(detector.getLogin());
        newcreateFileProvidence.setIpModifica(detector.getIp());
        return expedienteProvidenciaRepository.save(newcreateFileProvidence);
    }
}
