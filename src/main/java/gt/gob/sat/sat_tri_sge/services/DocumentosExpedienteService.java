/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.services;

import gt.gob.sat.sat_tri_sge.projections.DocumentosExpedienteProjection;
import gt.gob.sat.sat_tri_sge.repositories.DocumentosExpedienteRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alexa
 */
@Transactional
@Service
@Slf4j
public class DocumentosExpedienteService {
    
    @Autowired
    private DocumentosExpedienteRepository documentosExpedienteRepository;
    
    public List<DocumentosExpedienteProjection> getExpediente(String no_expediente){
        log.debug("Obtener Expediente");
        return documentosExpedienteRepository.getNoExpediente(no_expediente);
    }
    
}
