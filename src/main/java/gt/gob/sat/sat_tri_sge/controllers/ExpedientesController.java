/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.controllers;

import gt.gob.sat.sat_tri_sge.dtos.AnexoDTO;
import gt.gob.sat.sat_tri_sge.dtos.ComplementoExpedienteDTO;
import gt.gob.sat.sat_tri_sge.dtos.ExpedienteImpuestoDTO;
import gt.gob.sat.sat_tri_sge.dtos.ExpedientesDTO;
import gt.gob.sat.sat_tri_sge.dtos.ObservacionDTO;
import gt.gob.sat.sat_tri_sge.dtos.PrestamoDTO;
import gt.gob.sat.sat_tri_sge.dtos.ResumenDTO;
import gt.gob.sat.sat_tri_sge.projections.ExpedientesProjection;
import gt.gob.sat.sat_tri_sge.projections.ExpedientesProjetions;
import gt.gob.sat.sat_tri_sge.projections.ReporteProjection;
import gt.gob.sat.sat_tri_sge.services.ExpedientesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author crist
 */

@Api(tags = {"File"})
@Validated
@RestController
@Slf4j
@RequestMapping("/Files")

public class ExpedientesController {
    
   @Autowired
   private ExpedientesService expedientesService;
   
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Obtener un colobarador en especifico.")
    public ResponseEntity<List<ExpedientesProjection>> getColaborators(){    
        return ResponseEntity.ok(expedientesService.getFiles());
    }
    
    @PostMapping(path = "/CreateComplemnt", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crea un Complemento de Expediente.")
    public ResponseEntity<?> CreateComplement(@RequestBody ComplementoExpedienteDTO dto){
        return ResponseEntity.ok(expedientesService.createComplement(dto));
    }
    
    @PutMapping(path = "/Update/{noExpedienteTributa}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza el estado del Expediente.")
    public void PutColaborator(@PathVariable (required = true) String noExpedienteTributa, 
            @RequestBody ExpedientesDTO dto){
        expedientesService.updateState(dto, noExpedienteTributa);
    }
    
    @PostMapping(path = "/Create/File", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crea un Expediente")
    public ResponseEntity<?> CreateFile(@RequestBody ExpedientesDTO dto){
        return ResponseEntity.ok(expedientesService.createFile(dto));
    }
    
    @PostMapping(path = "/Create/Observation", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crea una observacion")
    public ResponseEntity<?> createObservation(@RequestBody ObservacionDTO dto){
        return ResponseEntity.ok(expedientesService.createObservation(dto));
    }
    
    @PostMapping(path = "/Create/Anexo")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crea un anexo")
    public  ResponseEntity<?> createAnexo(@RequestBody AnexoDTO dto){
        return ResponseEntity.ok(expedientesService.createAnexo(dto));
    }
    
    @PostMapping(path = "/Create/Loan")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crea un prestamo")
    public  ResponseEntity<?> createLoan(@RequestBody PrestamoDTO dto){
        return ResponseEntity.ok(expedientesService.createLoan(dto));
    }
    
    @PutMapping(path = "/Update/Loan/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza la fecha de entrada del prestamo")
    public void PutLoan(@PathVariable (required = true) int id, 
            @RequestBody PrestamoDTO dto){
        expedientesService.updateLoan(dto, id);
    }
    
    @PostMapping(path = "/Create/FileTax")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crea el impuesto que tiene el expediente")
    public ResponseEntity<?> createFileTax(@RequestBody ExpedienteImpuestoDTO dto){
        return ResponseEntity.ok(expedientesService.createFileTax(dto));
    }
    
    @PostMapping(path = "/Create/Resumen")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crea el resumen de un expediente")
    public ResponseEntity<?> createResumen(@RequestBody ResumenDTO dto){
        return ResponseEntity.ok(expedientesService.CreateResumen(dto));
    }
    
    @PutMapping(path = "/Update/Resumen", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza el resumen de un expediente")
    public void updateResumen(@RequestBody ResumenDTO dto){
        expedientesService.UpdateResumen(dto);
    }
    
    @GetMapping(path = "/Files/{nit}/{lista}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Obtienen todos los expedeintes de un colaborador.")
    public ResponseEntity<List<ExpedientesProjetions>> getFiles(@PathVariable String nit, @PathVariable List<Integer> lista) {
        List<Integer> estados = Arrays.asList(3, 1);
        return ResponseEntity.ok(expedientesService.getFiles(nit, lista));
    }
    
    @GetMapping(path = "/Report", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Obtienen todos los expedeintes de un colaborador.")
    public ResponseEntity<List<ReporteProjection>> getReport() {
        return ResponseEntity.ok(expedientesService.Report());
    }
}
