/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.services;

import gt.gob.sat.arquitectura.microservices.config.request.Detector;
import gt.gob.sat.sat_tri_sge.dtos.AgendaDTO;
import gt.gob.sat.sat_tri_sge.models.SgeAgenda;
import gt.gob.sat.sat_tri_sge.projections.AgendaProjection;
import gt.gob.sat.sat_tri_sge.projections.ProvidenciaProjection;
import gt.gob.sat.sat_tri_sge.repositories.AgendaRepository;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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
    
    @Autowired
    private Detector detector;
    
    @Transactional(readOnly = true)
    public List<AgendaProjection> diaryLista(int tipo){
        return agendaRepository.diaryList(tipo);
    }
    
    @Transactional(readOnly = true)
    public List<AgendaProjection> specialistLista(String tipo){
        return agendaRepository.specialistList(tipo);
    }
    
    @Transactional
    public SgeAgenda createDiary(AgendaDTO dto){
        final SgeAgenda newDiary = new SgeAgenda();
        newDiary.setAsuntoAgenda(dto.getAsuntoAgenda());
        newDiary.setFechaCreacion(dto.getFechaCreacion());
        newDiary.setFechaModifica(new Date());
        newDiary.setIdAgenda(createId(dto.getTipoAgenda()));
        newDiary.setIpModifica(detector.getIp());
        newDiary.setTipoAgenda(dto.getTipoAgenda());
        newDiary.setUsuarioModifica(detector.getLogin());
        return agendaRepository.save(newDiary);
    }
    
    private String createId(int tipo){
        String id = "";
        int num = 1;
        ProvidenciaProjection lastId = agendaRepository.getLastId(tipo);
        SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
        String currentYear = "";
        if (lastId != null) {
            currentYear = getYearFormat.format(lastId.getFecha_creacion());
            if (currentYear.equals(Integer.toString(LocalDate.now().getYear()))) {
                num = getNumber(lastId.getId());
            }
        }
        if (tipo == 9) {
            id += "TAT-";
        } else if (tipo == 10) {
            id += "TAA-";
        }

        id += Integer.toString(num) + "-";
        id += LocalDate.now().getYear();
        return id;
    }
    
    public int getNumber(String text) {
        int state = 1;
        String num = "";
        System.out.println("El texto de entrada"+text);
        for (int i = 0; i < text.length(); i++) {
            if (state == 1) {
                if (Character.isDigit(text.charAt(i))) {
                    state = 2;
                }
            }
            if (state == 2) {
                if (Character.isDigit(text.charAt(i))) {
                    num += text.charAt(i);
                } else {
                    break;
                }
            }
        }
        return Integer.parseInt(num) + 1;
    }
    
}
