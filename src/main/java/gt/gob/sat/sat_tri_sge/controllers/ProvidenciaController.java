/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.controllers;

import gt.gob.sat.sat_tri_sge.dtos.ExpedienteProvidenciaDTO;
import gt.gob.sat.sat_tri_sge.dtos.ProvidenciaDTO;
import gt.gob.sat.sat_tri_sge.services.ProvidenciaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author crist
 */

@Api(tags = {"Providencia"})
@Validated
@RestController
@Slf4j
@RequestMapping("/Providens")

public class ProvidenciaController {

    @Autowired
    private ProvidenciaService providenciaService;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crea una providencia de entrada.")
    public ResponseEntity<?> createProvidence(@RequestBody ProvidenciaDTO dto) {
        return ResponseEntity.ok(providenciaService.createProvidence(dto));
    }

    @PostMapping(path = "/file/crate", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "asigna un providencia a un expediente.")
    public ResponseEntity<?> createFileProvidence(@RequestBody ExpedienteProvidenciaDTO dto) {
        return ResponseEntity.ok(providenciaService.createFileProvidence(dto));
    }
}
