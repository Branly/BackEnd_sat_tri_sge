/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.services;

import gt.gob.sat.sat_tri_sge.projections.DatosProjection;
import gt.gob.sat.sat_tri_sge.repositories.CatDatoRepository;
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

public class CatDatoService {
    
    @Autowired
    private CatDatoRepository catDatoRepository;
    
    @Transactional(readOnly = true)
    public List<DatosProjection> data(int tipo){
        return catDatoRepository.data(tipo);
    }
    
    @Transactional(readOnly = true)
    public List<DatosProjection> subData(int tipo){
        return catDatoRepository.subData(tipo);
    }
}
