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
import gt.gob.sat.sat_tri_sge.projections.ProvidenciaProjection;
import gt.gob.sat.sat_tri_sge.repositories.ExpedienteProvidenciaRepitory;
import gt.gob.sat.sat_tri_sge.repositories.ProvidenciaRepository;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
        newProvidence.setIdProvidencia(genrateId(dto));
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
        System.out.println("es el dto");
        System.out.println(dto);
        final SgeExpedienteProvidencia newcreateFileProvidence = new SgeExpedienteProvidencia();
        newcreateFileProvidence.setId(new SgeExpedienteProvidenciaId(dto.getIdProvidencia(), dto.getNoexpediente()));
        newcreateFileProvidence.setComentario(dto.getComentario());
        newcreateFileProvidence.setResolucion(dto.getResolucion());
        newcreateFileProvidence.setFechaModifica(new Date());
        newcreateFileProvidence.setUsuarioModifica(detector.getLogin());
        newcreateFileProvidence.setIpModifica(detector.getIp());
        return expedienteProvidenciaRepository.save(newcreateFileProvidence);
    }

    @Transactional
    public String genrateId(ProvidenciaDTO dto) {
        String id = "PRO-SAT-TRI-";
        int num = 1;
        SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
        String currentYear = getYearFormat.format(dto.getFechaCreacion());
        ProvidenciaProjection newProvidens = getLastId(dto.getIdTribunal(), dto.getTipoProvidencia());
        System.out.println("año  "+currentYear);
        if (currentYear.equals(Integer.toString(LocalDate.now().getYear()))) {
            num = getNumber(newProvidens.getId());
        }
        if (dto.getIdTribunal() == 9) {
            id += "TAT-";
        } else if (dto.getTipoProvidencia() == 10) {
            id += "TAA-";
        }
        id += Integer.toString(num) + "-";
        id += LocalDate.now().getYear();
        return id;
    }

    @Transactional
    public ProvidenciaProjection getLastId(int tribunal, int tipo) {
        return providenciaRepository.idProvidens(tribunal, tipo);
    }

    public int getNumber(String text) {
        int state = 1;
        String num = "";
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
