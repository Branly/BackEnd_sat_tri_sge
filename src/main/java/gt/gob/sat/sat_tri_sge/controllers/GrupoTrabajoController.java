/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.controllers;

import gt.gob.sat.sat_tri_sge.dtos.GrupotrabajoDTO;
import gt.gob.sat.sat_tri_sge.dtos.IntegranteGurpoDTO;
import gt.gob.sat.sat_tri_sge.services.GrupoTrabajoService;
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
import gt.gob.sat.sat_tri_sge.projections.GrupoTrabajoProjection;

/**
 *
 * @author crist
 */

@Api(tags = {"Grupos"})
@Validated
@RestController
@Slf4j
@RequestMapping("/gruposTrabajo")

public class GrupoTrabajoController {
    
    @Autowired
    private GrupoTrabajoService grupoTrabajoService;
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Obtiene los grupos disponibles")
    public ResponseEntity<List<GrupoTrabajoProjection>> Groups(){
        return ResponseEntity.ok(grupoTrabajoService.getGroups());
    }
    
    @PostMapping(path = "/Create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crea un grupo.")
    public ResponseEntity<?> CreateColaborator(@RequestBody GrupotrabajoDTO dtoColaborador){
        return ResponseEntity.ok(grupoTrabajoService.createGroup(dtoColaborador));
    }
    
    
    @DeleteMapping(path = "/Delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Elimina logicamente un grupo.")
    public void DeletGroup(@PathVariable (required = true) int id){
        grupoTrabajoService.deletGroup(id);
    }
    
    @PutMapping(path = "/Update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza un grupo.")
    public void PutColaborator(@PathVariable (required = true) int id, 
            @RequestBody GrupotrabajoDTO dto){
        grupoTrabajoService.updateGoup(id, dto);
    }
    
    @PostMapping(path = "/Create/Member", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crea un grupo.")
    public ResponseEntity<?> CreateMember(@RequestBody IntegranteGurpoDTO dto){
        return ResponseEntity.ok(grupoTrabajoService.createMemberGroup(dto));
    }
    
    @PutMapping(path = "/Update/Member", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza un grupo.")
    public void PutColaborator(@RequestBody IntegranteGurpoDTO dto){
        grupoTrabajoService.updateMemberGroup(dto);
    }
    
    @DeleteMapping(path = "/Delete/Member", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Elimina a un miembro del grupo.")
    public void DeletGroup(@RequestBody IntegranteGurpoDTO dto){
        grupoTrabajoService.deleteMember(dto);
    }
    
}
