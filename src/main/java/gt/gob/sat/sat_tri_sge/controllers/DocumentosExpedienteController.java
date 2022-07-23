/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.controllers;

import gt.gob.sat.arquitectura.microservices.config.request.Detector;
import gt.gob.sat.sat_tri_sge.Utils.ReportesUtils;
import gt.gob.sat.sat_tri_sge.services.DocumentosExpedienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alexa
 */

@Api(tags = {"Documentos"})
@Validated
@RestController
@Slf4j
@RequestMapping("/documents")
public class DocumentosExpedienteController {
    
    @Autowired
    DocumentosExpedienteService DocumentosExpedienteServie;
    
    @Autowired
    Detector detector;
    
    @GetMapping(path="/documentos/{no_expediente}",
            produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="Obtener el expediente")
    public void documentosGeneralExpediente(
    @PathVariable String no_expediente,
            HttpServletResponse response ){
                ReportesUtils.crearReporte(DocumentosExpedienteServie.getExpediente(no_expediente), "C:/SAT/Tributa/BackEnd_sat_tri_sge/src/main/resources/BoletaRechazadoExpediente.jrxml", response, ReportesUtils.WORD);
    }
    
}
