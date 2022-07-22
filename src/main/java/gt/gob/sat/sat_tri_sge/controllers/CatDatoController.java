/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.controllers;

import gt.gob.sat.sat_tri_sge.projections.DatosProjection;
import gt.gob.sat.sat_tri_sge.services.CatDatoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author crist
 */
@Api(tags = {"Cat Dato"})
@Validated
@RestController
@Slf4j
@RequestMapping("/CatData")
public class CatDatoController {
    @Autowired
    private CatDatoService catDatoService;
    
    @GetMapping(path = "/{tipo}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Obtiene los Catalogos disponibles.")
    public ResponseEntity<List<DatosProjection>> data(@PathVariable int tipo){    
        return ResponseEntity.ok(catDatoService.data(tipo));
    }
    
    @GetMapping(path = "/Sub/{tipo}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Obtiene los SubCatalogos disponibles.")
    public ResponseEntity<List<DatosProjection>> subData(@PathVariable int tipo){    
        return ResponseEntity.ok(catDatoService.subData(tipo));
    }
    
}
