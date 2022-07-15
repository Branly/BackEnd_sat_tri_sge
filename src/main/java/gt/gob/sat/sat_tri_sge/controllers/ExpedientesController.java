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
import gt.gob.sat.sat_tri_sge.projections.AsignacionManualProjection;
import gt.gob.sat.sat_tri_sge.projections.ExpedientesProjection;
import gt.gob.sat.sat_tri_sge.projections.ExpedientesProjetions;
import gt.gob.sat.sat_tri_sge.projections.RecepcionistaProjection;
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

    @GetMapping(path = "/Tributario" ,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Obtener los expedientes del presidente Tributario.")
    public ResponseEntity<List<ExpedientesProjection>> getFileTributary(){
        return ResponseEntity.ok(expedientesService.getFiles(9));
    }
    
    @GetMapping(path = "/Aduanero" ,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Obtener los expedientes del presidente Aduanero.")
    public ResponseEntity<List<ExpedientesProjection>> getFileCustoms(){
        return ResponseEntity.ok(expedientesService.getFiles(10));
    }

    @PostMapping(path = "/Complemnt", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crea un Complemento de Expediente.")
    public ResponseEntity<?> CreateComplement(@RequestBody ComplementoExpedienteDTO dto) {
        return ResponseEntity.ok(expedientesService.createComplement(dto));
    }

    @PutMapping(path = "/State/{noExpedienteTributa}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza el estado del Expediente.")
    public void PutColaborator(@PathVariable(required = true) String noExpedienteTributa) {
        expedientesService.updateState(1, noExpedienteTributa);
    }

    @PostMapping(path = "/File", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crea un Expediente")
    public ResponseEntity<?> CreateFile(@RequestBody ExpedientesDTO dto) {
        return ResponseEntity.ok(expedientesService.createFile(dto));
    }

    @PostMapping(path = "/Observation", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crea una observacion")
    public ResponseEntity<?> createObservation(@RequestBody ObservacionDTO dto) {
        return ResponseEntity.ok(expedientesService.createObservation(dto));
    }

    @PostMapping(path = "/Anexo")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crea un anexo")
    public ResponseEntity<?> createAnexo(@RequestBody AnexoDTO dto) {
        return ResponseEntity.ok(expedientesService.createAnexo(dto));
    }

    @PostMapping(path = "/Loan")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crea un prestamo")
    public ResponseEntity<?> createLoan(@RequestBody PrestamoDTO dto) {
        return ResponseEntity.ok(expedientesService.createLoan(dto));
    }

    @PutMapping(path = "/Loan/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza la fecha de entrada del prestamo")
    public void PutLoan(@PathVariable(required = true) int id,
            @RequestBody PrestamoDTO dto) {
        expedientesService.updateLoan(dto, id);
    }

    @PostMapping(path = "/FileTax")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crea el impuesto que tiene el expediente")
    public ResponseEntity<?> createFileTax(@RequestBody ExpedienteImpuestoDTO dto) {
        return ResponseEntity.ok(expedientesService.createFileTax(dto));
    }

    @PostMapping(path = "/Resumen")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crea el resumen de un expediente")
    public ResponseEntity<?> createResumen(@RequestBody ResumenDTO dto) {
        return ResponseEntity.ok(expedientesService.CreateResumen(dto));
    }

    @PutMapping(path = "/Resumen", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza el resumen de un expediente")
    public void updateResumen(@RequestBody ResumenDTO dto) {
        expedientesService.UpdateResumen(dto);
    }

    @GetMapping(path = "/Files/{nit}/{lista}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Obtienen todos los expedeintes de un colaborador.")
    public ResponseEntity<List<ExpedientesProjetions>> getFiles(@PathVariable String nit, @PathVariable List<Integer> lista) {
        List<Integer> estados = Arrays.asList(3, 1);
        return ResponseEntity.ok(expedientesService.getFiles(nit, lista));
    }

    @GetMapping(path = "/Report/{anio}/{mes}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Obtienen todos los expedeintes del mes y año solicitado.")
    public ResponseEntity<List<ReporteProjection>> getReport(@PathVariable int anio, @PathVariable int mes) {
        return ResponseEntity.ok(expedientesService.Report(anio, mes));
    }

    @GetMapping(path = "/DiaryFile/{agenda}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Obtienen los expedientes de una agenda solicitada")
    public ResponseEntity<List<ExpedientesProjetions>> diaryFile(@PathVariable String agenda) {
        return ResponseEntity.ok(expedientesService.diaryFile(agenda));
    }

    @PutMapping(path = "/StateReturned/{noExpedienteTributa}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza el estado del Expediente a Devuelto.")
    public void stateReturned(@PathVariable(required = true) String noExpedienteTributa) {
        expedientesService.updateState(5, noExpedienteTributa);
        expedientesService.assignProfessional(noExpedienteTributa, 45);
        
    }

    @PutMapping(path = "/StateLoan/{noExpedienteTributa}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza el estado del Expediente a En Prestamo.")
    public void stateLoan(@PathVariable(required = true) String noExpedienteTributa) {
        expedientesService.updateState(6, noExpedienteTributa);
        expedientesService.assignProfessional(noExpedienteTributa, 45);
    }

    @PutMapping(path = "/StateInformationComfirmation/{noExpedienteTributa}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza el estado del Expediente a Confirmacion de Informacion.")
    public void stateInformationComfirmation(@PathVariable(required = true) String noExpedienteTributa) {
        expedientesService.updateState(7, noExpedienteTributa);
        expedientesService.AssignmentCentralizer(noExpedienteTributa, "Centralizador de Entrada");
    }

    @PutMapping(path = "/StatePendigAssignment/{noExpedienteTributa}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza el estado del Expediente a Pendiente de Asignacion Profecional.")
    public void statePendigAssignment(@PathVariable(required = true) String noExpedienteTributa) {
        expedientesService.updateState(8, noExpedienteTributa);
        expedientesService.assignProfessional(noExpedienteTributa, 5);
        expedientesService.AssignmentCollaborator(noExpedienteTributa, 19);
    }

    @PutMapping(path = "/StatePendigDraftResolution/{noExpedienteTributa}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza el estado del Expediente a Pendiente de Proyecto de Resolucion.")
    public void statePendigDraftResolution(@PathVariable(required = true) String noExpedienteTributa) {
        expedientesService.updateState(28, noExpedienteTributa);
    }

    @PutMapping(path = "/StateProfessionalCorrection/{noExpedienteTributa}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza el estado del Expediente a Correccion de Profesional.")
    public void statePorfessionalCorrection(@PathVariable(required = true) String noExpedienteTributa) {
        expedientesService.updateState(30, noExpedienteTributa);
        expedientesService.AssignmentCollaborator(noExpedienteTributa, 19);
    }

    @PutMapping(path = "/StateElaborateProvidence/{noExpedienteTributa}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza el estado del Expediente a Providencia Elaborada.")
    public void stateElaborateProvidence(@PathVariable(required = true) String noExpedienteTributa) {
        expedientesService.updateState(31, noExpedienteTributa);
    }

    @PutMapping(path = "/StateSupervisorReview/{noExpedienteTributa}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza el estado del Expediente a En Revicion de Supervisor.")
    public void stateSupervisorReview(@PathVariable(required = true) String noExpedienteTributa) {
        expedientesService.updateState(32, noExpedienteTributa);
        expedientesService.AssignmentCollaborator(noExpedienteTributa, 20);
    }

    @PutMapping(path = "/StateSupervisorCorrection/{noExpedienteTributa}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza el estado del Expediente a Correcion de Supervisor.")
    public void stateSupervisorCorrection(@PathVariable(required = true) String noExpedienteTributa) {
        expedientesService.updateState(33, noExpedienteTributa);
        expedientesService.AssignmentCollaborator(noExpedienteTributa, 20);
    }

    @PutMapping(path = "/StatePaperApproval/{noExpedienteTributa}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza el estado del Expediente a Sin aprobación de ponencia.")
    public void statePaperApproval(@PathVariable(required = true) String noExpedienteTributa) {
        expedientesService.updateState(34, noExpedienteTributa);
        expedientesService.AssignmentCollaborator(noExpedienteTributa, 20);
    }

    @PutMapping(path = "/StateSpecialistReview/{noExpedienteTributa}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza el estado del Expediente a En Revicion de Especialista.")
    public void stateSpecialistReview(@PathVariable(required = true) String noExpedienteTributa) {
        expedientesService.updateState(35, noExpedienteTributa);
        expedientesService.AssignmentCollaborator(noExpedienteTributa, 21);
    }

    @PutMapping(path = "/StatePonent/{noExpedienteTributa}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza el estado del Expediente a Ponente.")
    public void statePonent(@PathVariable(required = true) String noExpedienteTributa) {
        expedientesService.updateState(36, noExpedienteTributa);
        expedientesService.AssignmentCollaborator(noExpedienteTributa, 21);
    }

    @PutMapping(path = "/StatePendingDiary/{noExpedienteTributa}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza el estado del Expediente a Pendiente de agenda.")
    public void statePendigDiary(@PathVariable(required = true) String noExpedienteTributa) {
        expedientesService.updateState(37, noExpedienteTributa);
        expedientesService.AssignmentCollaborator(noExpedienteTributa, 1);
    }

    @PutMapping(path = "/StateResolutionCreation/{noExpedienteTributa}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza el estado del Expediente a Creación de resolución.")
    public void stateResolutionCreation(@PathVariable(required = true) String noExpedienteTributa) {
        expedientesService.updateState(38, noExpedienteTributa);
    }

    @PutMapping(path = "/StateCertify/{noExpedienteTributa}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza el estado del Expediente a Certificar.")
    public void stateCertify(@PathVariable(required = true) String noExpedienteTributa) {
        expedientesService.updateState(39, noExpedienteTributa);
        expedientesService.AssignmentCentralizer(noExpedienteTributa, "Centralizador de Salida");
    }

    @PutMapping(path = "/StateApprovedCertificate/{noExpedienteTributa}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza el estado del Expediente a Cédula Aprobada.")
    public void stateApprovedCertificate(@PathVariable(required = true) String noExpedienteTributa) {
        expedientesService.updateState(40, noExpedienteTributa);
    }

    @PutMapping(path = "/StateDepartureProvidenceCreated/{noExpedienteTributa}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza el estado del Expediente a PRovidencia de Salida Creada.")
    public void stateDepartureProvidenceCreated(@PathVariable(required = true) String noExpedienteTributa) {
        expedientesService.updateState(41, noExpedienteTributa);
    }

    @PutMapping(path = "/StateFinalized/{noExpedienteTributa}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Actualiza el estado del Expediente a Finalizado.")
    public void stateFinalized(@PathVariable(required = true) String noExpedienteTributa) {
        expedientesService.updateState(42, noExpedienteTributa);
    }

    @PutMapping(path = "/complement/{noExpedienteTributa}/{nit}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Agrega al colaborador que confronta")
    public void complement(@PathVariable(required = true) String noExpedienteTributa, @PathVariable(required = true) String nit) {
        expedientesService.updateComplement(noExpedienteTributa, nit);
    }
    
    @PutMapping(path = "/manualAssignment/{noExpedienteTributa}/{nit}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Asigna manualmete un Profesional a un Expediente")
    public void manualAssignment(@PathVariable(required = true) String noExpedienteTributa, @PathVariable(required = true) String nit) {
        expedientesService.updateState(28, noExpedienteTributa);
        expedientesService.manualAssignment(noExpedienteTributa, nit);
    }
    
    @PutMapping(path = "/diaryAssignment/{noExpedienteTributa}/{idagenda}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Asigna una expediente a una agenda")
    public void diaryAssignment(@PathVariable(required = true) String noExpedienteTributa, @PathVariable(required = true) String idagenda) {
        expedientesService.diaryAssignment(noExpedienteTributa, idagenda);
    }
    
    @PutMapping(path = "/confrontationAssignment/{noExpedienteTributa}/{nit}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Asigna manualmete un Profesional que Confronta a un Expediente")
    public void confrontationAssignment(@PathVariable(required = true) String noExpedienteTributa, @PathVariable(required = true) String nit) {
        expedientesService.confrontationAssignment(noExpedienteTributa, nit);
    }
    
    @GetMapping(path = "/Receptionist", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Obtener los expedientes.")
    public ResponseEntity<List<RecepcionistaProjection>> receptionist() {
        return ResponseEntity.ok(expedientesService.receptionist());
    }
    
    @GetMapping(path = "/Coordinator", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Obtener los expedientes.")
    public ResponseEntity<List<AsignacionManualProjection>> coordinatorFiles() {
        return ResponseEntity.ok(expedientesService.coordinator());
    }
    
    @GetMapping(path = "/Verification/{expediente}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Obtener los expedientes.")
    public ResponseEntity<List<ExpedientesProjection>> informationVerification(@PathVariable(required = true) String expediente) {
        return ResponseEntity.ok(expedientesService.informationVerification(expediente));
    }
    
    @GetMapping(path = "/informationProfessional/{expediente}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Obtener la informacion de un expediente asignadio a un profesional.")
    public ResponseEntity<ExpedientesProjection> informationProfessional(@PathVariable(required = true) String expediente) {
        return ResponseEntity.ok(expedientesService.informationProfessional(expediente));
    }
}
