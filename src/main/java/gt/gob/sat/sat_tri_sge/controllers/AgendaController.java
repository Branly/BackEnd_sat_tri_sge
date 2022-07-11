/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.controllers;
import gt.gob.sat.sat_tri_sge.projections.AgendaProjection;
import gt.gob.sat.sat_tri_sge.services.AgendaService;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author crist
 */

@Api(tags = {"Agenda"})
@Validated
@RestController
@Slf4j
@RequestMapping("/Diary")
public class AgendaController {
    
    @Autowired
    private AgendaService agendaService;
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Obtiene las agendas disponibles.")
    public ResponseEntity<List<AgendaProjection>> diaryList(){    
        return ResponseEntity.ok(agendaService.diaryLista());
    }
    
}
