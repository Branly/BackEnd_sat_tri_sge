/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.services;

import gt.gob.sat.sat_tri_sge.projections.AgendaProjection;
import gt.gob.sat.sat_tri_sge.repositories.AgendaRepository;
import java.util.List;
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

public class AgendaService {
    
    @Autowired
    private AgendaRepository agendaRepository;
    
    @Transactional(readOnly = true)
    public List<AgendaProjection> diaryLista(){
        return agendaRepository.diaryList();
    }
    
}
