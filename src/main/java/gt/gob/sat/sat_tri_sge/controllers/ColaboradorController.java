/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.controllers;

import gt.gob.sat.sat_tri_sge.dtos.ColaboradorDTO;
import gt.gob.sat.sat_tri_sge.dtos.HistorialEstadosColaboradorDTO;
import gt.gob.sat.sat_tri_sge.services.ColaboradorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import gt.gob.sat.sat_tri_sge.projections.ColaboradorProjection;

/**
 *
 * @author crist
 */

@Api(tags = {"Colaborador"})
@Validated
@RestController
@Slf4j
@RequestMapping("/colaborators")

public class ColaboradorController {
    
    @Autowired
    ColaboradorService colaboradorService;
    
    @GetMapping(path = "/{nit}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Obtener un colobarador en especifico.")
    public ResponseEntity<List<ColaboradorProjection>> getColaborators(@PathVariable String nit){    
        return ResponseEntity.ok(colaboradorService.getColaborator(nit));
    }
    
    @PostMapping(path = "/Create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crea un colobarador.")
    public ResponseEntity<?> CreateColaborator(@RequestBody ColaboradorDTO dtoColaborador){
        return ResponseEntity.ok(colaboradorService.CreateColaborator(dtoColaborador));
    }
    
    @DeleteMapping(path = "/Delete/{nit}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Elimina logicamente un colobarador.")
    public void DeleteColaborator(@PathVariable (required = true) String nit, @RequestBody HistorialEstadosColaboradorDTO dto){
        colaboradorService.DeleteColaborador(nit, dto);
    }
    
    
    @PutMapping(path = "/Update/{nit}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza un colobarador.")
    public void PutColaborator(@PathVariable (required = true) String nit, 
            @RequestBody ColaboradorDTO dto){
        colaboradorService.PutColaborador(nit, dto);
    }
    
    @PostMapping(path = "/CreateHistory", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crea un historial de colaborador.")
    public ResponseEntity<?> CreateHistory(@RequestBody HistorialEstadosColaboradorDTO dtoHistorial){
        return  ResponseEntity.ok(colaboradorService.CreateHistory(dtoHistorial));
    }
    
    @GetMapping(path = "CollaboratorRole/{puesto}/{tipo}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Obtener a los colaboradores segun su rol.")
    public ResponseEntity<List<ColaboradorProjection>> CollaboratorRole(@PathVariable Integer puesto, @PathVariable Integer tipo){    
        return ResponseEntity.ok(colaboradorService.CollaboratorRol(puesto, tipo));
    }
    
}
