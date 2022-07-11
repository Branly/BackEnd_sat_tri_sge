/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.services;

import gt.gob.sat.arquitectura.microservices.config.request.Detector;
import gt.gob.sat.sat_tri_sge.dtos.AnexoDTO;
import gt.gob.sat.sat_tri_sge.dtos.BitacoraAsignacionColaboradorDTO;
import gt.gob.sat.sat_tri_sge.dtos.ComplementoExpedienteDTO;
import gt.gob.sat.sat_tri_sge.dtos.ExpedienteImpuestoDTO;
import gt.gob.sat.sat_tri_sge.dtos.ExpedientesDTO;
import gt.gob.sat.sat_tri_sge.dtos.ObservacionDTO;
import gt.gob.sat.sat_tri_sge.dtos.PrestamoDTO;
import gt.gob.sat.sat_tri_sge.dtos.ResumenDTO;
import gt.gob.sat.sat_tri_sge.models.SgeAnexo;
import gt.gob.sat.sat_tri_sge.models.SgeColaborador;
import gt.gob.sat.sat_tri_sge.models.SgeComplementoExpediente;
import gt.gob.sat.sat_tri_sge.models.SgeExpediente;
import gt.gob.sat.sat_tri_sge.models.SgeExpedienteImpuesto;
import gt.gob.sat.sat_tri_sge.models.SgeExpedienteImpuestoId;
import gt.gob.sat.sat_tri_sge.models.SgeHistorialEstadoExpediente;
import gt.gob.sat.sat_tri_sge.models.SgeObservacion;
import gt.gob.sat.sat_tri_sge.models.SgePrestamo;
import gt.gob.sat.sat_tri_sge.models.SgeResumen;
import gt.gob.sat.sat_tri_sge.projections.AsignacionManualProjection;
import gt.gob.sat.sat_tri_sge.projections.ExpedientesProjection;
import gt.gob.sat.sat_tri_sge.projections.ExpedientesProjetions;
import gt.gob.sat.sat_tri_sge.projections.ProfesionalProjection;
import gt.gob.sat.sat_tri_sge.projections.RecepcionistaProjection;
import gt.gob.sat.sat_tri_sge.projections.ReporteProjection;
import gt.gob.sat.sat_tri_sge.projections.ResumenProjection;
import gt.gob.sat.sat_tri_sge.repositories.AnexoRepository;
import gt.gob.sat.sat_tri_sge.repositories.ColaboradorRepository;
import gt.gob.sat.sat_tri_sge.repositories.ComplementoExpedienteRepository;
import gt.gob.sat.sat_tri_sge.repositories.ExpedienteImpuestoRepository;
import gt.gob.sat.sat_tri_sge.repositories.ExpedientesRepository;
import gt.gob.sat.sat_tri_sge.repositories.HistorialEstadosExpedienteRepository;
import gt.gob.sat.sat_tri_sge.repositories.ObservacionRepository;
import gt.gob.sat.sat_tri_sge.repositories.PrestamoRepository;
import gt.gob.sat.sat_tri_sge.repositories.ResumenRepository;
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

public class ExpedientesService {

    @Autowired
    private ExpedientesRepository expedientesRepository;

    @Autowired
    private ComplementoExpedienteRepository complentoExpedienteRepository;

    @Autowired
    private Detector detector;

    @Autowired
    private ObservacionRepository observacionRepository;

    @Autowired
    private AnexoRepository anexoRepository;

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private ExpedienteImpuestoRepository expedienteImpuestoRepository;

    @Autowired
    private ResumenRepository resumenRepository;

    @Autowired
    private ColaboradorRepository colaboradoRepository;

    @Autowired
    private HistorialEstadosExpedienteRepository historialEstadosExpedienteRepository;

    @Autowired
    private ColaboradorService colaboradorService;

    @Transactional(readOnly = true)
    public List<ExpedientesProjection> getFiles(int tipo) {
        log.debug("Obteniendo Expedientes");
        return expedientesRepository.expedientes(tipo);
    }

    /**
     * Metodo para crear un Expediente
     *
     * @author Gabriel runao (agaruanom)
     * @param dto
     * @since 16/06/2022
     * @return fileCreate
     */
    @Transactional
    public SgeExpediente createFile(ExpedientesDTO dto) {
        final SgeExpediente fileCreate = new SgeExpediente();
        fileCreate.setCantidadAjustes(dto.getCantidadAjustes());
        fileCreate.setDireccionFiscal(dto.getDireccionFiscal());
        fileCreate.setFechaIngreso(new Date());
        fileCreate.setFechaModifica(new Date());
        fileCreate.setFolios(dto.getFolios());
        fileCreate.setGerenciaOrigen(dto.getGerenciaOrigen());
        fileCreate.setIdEstado(dto.getIdEstado());
        fileCreate.setIdProces(dto.getIdProces());
        fileCreate.setNitContribuyente(dto.getNitContribuyente());
        fileCreate.setNoExpedienteTributa(dto.getNoExpedienteTributa());
        fileCreate.setNoExpediente(dto.getNoExpediente());
        fileCreate.setTipoRecurso(dto.getTipoRecurso());
        fileCreate.setIpModifica(detector.getIp());
        fileCreate.setUsuarioModifica(detector.getLogin());
        return expedientesRepository.save(fileCreate);
    }

    /**
     * Metodo para obtener los expedientes asignados a un Supervisor
     *
     * @author Cristian Raguay (acdraguay)
     * @param nit
     * @param estados
     * @since 14/06/2022
     * @return getAllExpedienteSupervisor
     */
    @Transactional(readOnly = true)
    public List<ExpedientesProjetions> getFiles(String nit, List<Integer> estados) {
        log.debug("Obteniendo todos los expedientes de un colaborador");
        return expedientesRepository.getFiles(nit, estados);
    }

    /**
     * Metodo para crear un complemento de un Expediente
     *
     * @author Cristian Raguay (acdraguay)
     * @param dto
     * @since 14/06/2022
     * @return complementCreate
     */
    @Transactional
    public SgeComplementoExpediente createComplement(ComplementoExpedienteDTO dto) {
        final SgeComplementoExpediente complementCreate = new SgeComplementoExpediente();
        complementCreate.setNoExpedienteTributa(dto.getNoExpedienteTributa());
        complementCreate.setIdCasoEspecial(dto.getIdCasoEspecial());
        complementCreate.setTipoCaso(dto.getTipoCaso());
        complementCreate.setSubTipoCaso(dto.getSubTipoCaso());
        complementCreate.setComplejidad(this.complexityFile(dto.getNoExpedienteTributa()));
        complementCreate.setFechaInterposicion(dto.getFechaInterposicion());
        complementCreate.setFechaModifica(new Date());
        complementCreate.setUsuarioModifica(detector.getLogin());
        complementCreate.setIpModifica(detector.getIp());
        return complentoExpedienteRepository.save(complementCreate);
    }

    /**
     * Metodo para actualizar el estado de un Expediente
     *
     * @author Cristian Raguay (acdraguay)
     * @param estado
     * @param noExpedienteTributa
     * @since 14/06/2022
     * @return updateState
     */
    @Transactional
    public SgeExpediente updateState(int estado, String noExpedienteTributa) {
        final SgeExpediente updateState = expedientesRepository.findById(noExpedienteTributa).orElse(null);
        final SgeHistorialEstadoExpediente history = new SgeHistorialEstadoExpediente();
        history.setFechaModifica(new Date());
        history.setIdEstado(estado);
        history.setIpModifica(detector.getIp());
        history.setNoExpedienteTributa(noExpedienteTributa);
        history.setUsuarioModifica(detector.getLogin());
        updateState.setIdEstado(estado);
        historialEstadosExpedienteRepository.save(history);
        return expedientesRepository.save(updateState);
    }

    /**
     * Metodo para Agregar observaciones de un expediente
     *
     * @author Cristian Raguay (acdraguay)
     * @param dto
     * @since 14/06/2022
     * @return ObservationCreate
     */
    @Transactional
    public SgeObservacion createObservation(ObservacionDTO dto) {
        final SgeObservacion observationCreate = new SgeObservacion();
        observationCreate.setFechaModifica(new Date());
        observationCreate.setObservaciones(dto.getObservaciones());
        observationCreate.setNoExpedienteTributa(dto.getNoExpedienteTributa());
        observationCreate.setIpModifica(dto.getIpModifica());
        observationCreate.setUsuarioModifica(dto.getUsuarioModifica());
        return observacionRepository.save(observationCreate);
    }

    /**
     * Metodo para Agregar anexos a un Expedientes
     *
     * @author Cristian Raguay (acdraguay)
     * @param dto
     * @since 16/06/2022
     * @return AnexoCreate
     */
    @Transactional
    public SgeAnexo createAnexo(AnexoDTO dto) {
        final SgeAnexo anexoCreate = new SgeAnexo();
        anexoCreate.setFechaEntrada(new Date());
        anexoCreate.setFechaModifica(new Date());
        anexoCreate.setNoExpedienteTributa(dto.getNoExpedienteTributa());
        anexoCreate.setUsuarioModifica(detector.getLogin());
        anexoCreate.setIpModifica(detector.getIp());
        return anexoRepository.save(anexoCreate);
    }

    /**
     * Metodo para crear Prestamos de un expediente
     *
     * @author Cristian Raguay (acdraguay)
     * @param dto
     * @since 16/06/2022
     * @return loanCreate
     */
    @Transactional
    public SgePrestamo createLoan(PrestamoDTO dto) {
        final SgePrestamo loanCreate = new SgePrestamo();
        loanCreate.setNoExpedienteTributa(dto.getNoExpedienteTributa());
        loanCreate.setDepartamento(dto.getGerencia());
        loanCreate.setGerencia(dto.getGerencia());
        loanCreate.setNitSolicitante(dto.getNitSolicitante());
        loanCreate.setComentario(dto.getComentario());
        loanCreate.setFechaSalida(new Date());
        loanCreate.setUsuarioModifica(detector.getLogin());
        loanCreate.setFechaModifica(dto.getFechaModifica());
        loanCreate.setIpModifica(detector.getIp());
        return prestamoRepository.save(loanCreate);
    }

    /**
     * Metodo para actualizar un Prestamo
     *
     * @author Cristian Raguay (acdraguay)
     * @param dto
     * @param id
     * @since 16/06/2022
     * @return loanUpdate
     */
    @Transactional
    public SgePrestamo updateLoan(PrestamoDTO dto, int id) {
        final SgePrestamo loanUpdate = prestamoRepository.findById(id).orElse(null);
        loanUpdate.setFechaEntrada(new Date());
        loanUpdate.setUsuarioModifica(detector.getLogin());
        loanUpdate.setFechaModifica(new Date());
        loanUpdate.setIpModifica(detector.getIp());
        return prestamoRepository.save(loanUpdate);
    }

    /**
     * Metodo para agregar impuestos a un expediente
     *
     * @author Cristian Raguay (acdraguay)
     * @param dto
     * @since 16/06/2022
     * @return FileTaxCreate
     */
    @Transactional
    public SgeExpedienteImpuesto createFileTax(ExpedienteImpuestoDTO dto) {
        final SgeExpedienteImpuesto fileTaxCreate = new SgeExpedienteImpuesto();
        fileTaxCreate.setFechaModifica(new Date());
        fileTaxCreate.setId(new SgeExpedienteImpuestoId(dto.getNoExpedienteTributa(), dto.getIdIpmuesto()));
        fileTaxCreate.setIpModifica(detector.getIp());
        fileTaxCreate.setMonto(dto.getMonto());
        fileTaxCreate.setUsuarioModifica(detector.getLogin());
        return expedienteImpuestoRepository.save(fileTaxCreate);
    }

    /**
     * Metodo para crear el resumen del exediente
     *
     * @author Cristian Raguay (acdraguay)
     * @param dto
     * @since 20/06/2022
     * @return resumenCreate
     */
    @Transactional
    public SgeResumen CreateResumen(ResumenDTO dto) {
        final SgeResumen resumenCreate = new SgeResumen();
        resumenCreate.setFechaModifica(new Date());
        resumenCreate.setIpModifica(detector.getIp());
        resumenCreate.setNoExpedienteTributa(dto.getNoExpedienteTributa());
        resumenCreate.setResolucion(dto.getResolucion());
        resumenCreate.setResumen(dto.getResumen());
        resumenCreate.setSentido(dto.getSentido());
        resumenCreate.setUsuarioModifica(detector.getLogin());
        return resumenRepository.save(resumenCreate);
    }

    /**
     * Metodo para actualizar el resumen
     *
     * @author Cristian Raguay (acdraguay)
     * @param dto
     * @since 22/06/2022
     * @return resumenCreate
     */
    @Transactional
    public SgeResumen UpdateResumen(ResumenDTO dto) {
        final SgeResumen resumenCreate = resumenRepository.findById(dto.getIdResumen()).orElse(null);
        resumenCreate.setFechaModifica(new Date());
        resumenCreate.setIpModifica(detector.getIp());
        resumenCreate.setResolucion(dto.getResolucion());
        resumenCreate.setResumen(dto.getResumen());
        resumenCreate.setSentido(dto.getSentido());
        resumenCreate.setUsuarioModifica(detector.getLogin());
        return resumenRepository.save(resumenCreate);
    }

    /**
     * Metodo para obtener los expedientes de un mes para el reporte
     *
     * @author Cristian Raguay (acdraguay)
     * @param anio
     * @param mes
     * @since 22/06/2022
     * @return Report
     */
    @Transactional(readOnly = true)
    public List<ReporteProjection> Report(int anio, int mes) {
        return expedientesRepository.Report(anio, mes);
    }

    /**
     * Metodo para obtener los expedientes de una agenda en especifico
     *
     * @author Cristian Raguay (acdraguay)
     * @param agenda
     * @since 22/06/2022
     * @return DiaryFile
     */
    @Transactional(readOnly = true)
    public List<ExpedientesProjetions> diaryFile(String agenda) {
        return expedientesRepository.DiaryFiles(agenda);
    }

    /**
     * Metodo para obtener los resumenes para generar el documento Resumen.docx
     *
     * @author Cristian Raguay (acdraguay)
     * @param agenda
     * @since 22/06/2022
     * @return agenda
     */
    @Transactional(readOnly = true)
    public List<ResumenProjection> Resum(String agenda) {
        return expedientesRepository.Resum(agenda);
    }

    /**
     * Metodo para agregar al ponente del expediente
     *
     * @author Cristian Raguay (acdraguay)
     * @param id
     * @param nit
     * @since 24/06/2022
     * @return complement
     */
    @Transactional
    public SgeComplementoExpediente updateComplement(String id, String nit) {
        final SgeComplementoExpediente complement = complentoExpedienteRepository.findById(id).orElse(null);
        complement.setNitColaboradorConfronto(nit);
        return complentoExpedienteRepository.save(complement);
    }

    /**
     * Metodo para calcular la complejidad del expediente
     *
     * @author Cristian Raguay (acdraguay)
     * @param noFile
     * @since 24/06/2022
     * @return Resum
     */
    @Transactional
    private int complexityFile(String noFile) {
        final SgeExpediente file = expedientesRepository.findById(noFile).orElse(null);
        final List<ReporteProjection> impostList = expedientesRepository.impost(noFile);
        int materia = 0;
        int ajuste = 0;
        int monto = 0;
        for (int i = 0; i < impostList.size(); i++) {
            if (impostList.get(i).getImpuesto().equals("ISR")) {
                materia = 30;
                monto = complesityAmount(impostList.get(i).getMonto());
                break;
            } else if (impostList.get(i).getImpuesto().equals("Devolución") && materia < 25) {
                materia = 25;
                monto = complesityAmount(impostList.get(i).getMonto());
            } else if (impostList.get(i).getImpuesto().equals("IVA") && materia <= 10) {
                materia = 10;
                monto = complesityAmount(impostList.get(i).getMonto());
            } else if (impostList.get(i).getImpuesto().equals("ISO") && materia <= 10) {
                materia = 10;
                monto = complesityAmount(impostList.get(i).getMonto());
            } else if (impostList.get(i).getImpuesto().equals("OTROS") && materia < 10) {
                materia += 10;
                monto = complesityAmount(impostList.get(i).getMonto());
            }
        }

        if (file.getCantidadAjustes() == 1) {
            ajuste = 5;
        } else if (file.getCantidadAjustes() == 2 || file.getCantidadAjustes() == 3) {
            ajuste = 15;
        } else if (file.getCantidadAjustes() >= 4 && file.getCantidadAjustes() <= 7) {
            ajuste = 20;
        } else if (file.getCantidadAjustes() >= 8) {
            ajuste = 25;
        }
        return ajuste + monto + materia;
    }

    /**
     * Metodo para calcular la complejidad segun el monto del impuesto
     *
     * @author Cristian Raguay (acdraguay)
     * @param amount
     * @since 24/06/2022
     * @return complexity
     */
    private int complesityAmount(int amount) {
        int complexity = 0;
        if (amount >= 1000001) {
            complexity = 25;
        } else if (amount >= 150001 && amount <= 1000000) {
            complexity = 20;
        } else if (amount >= 50001 && amount <= 150000) {
            complexity = 15;
        } else if (amount >= 25001 && amount <= 50000) {
            complexity = 10;
        } else if (amount <= 25000) {
            complexity = 5;
        }
        return complexity;
    }

    /**
     * Metodo para asignar un profesional a un Expediente
     *
     * @author Cristian Raguay (acdraguay)
     * @param noFile
     * @param limite
     * @since 24/06/2022
     */
    @Transactional
    public void assignProfessional(String noFile, int limite) {
        final List<ProfesionalProjection> professionals = expedientesRepository.professional();
        final SgeComplementoExpediente complement = complentoExpedienteRepository.findById(noFile).orElse(null);
        final SgeExpediente file = expedientesRepository.findById(noFile).orElse(null);
        List<Integer> typeCase;
        for (ProfesionalProjection professional : professionals) {
            typeCase = expedientesRepository.caseType(professional.getNit(), limite);
            if (!typeCase.isEmpty()) {
                if (typeCase.contains(complement.getTipoCaso())) {
                    file.setNitProfesional(professional.getNit());
                    SgeColaborador collamorator = colaboradoRepository.findById(professional.getNit()).orElse(null);
                    collamorator.setCargaTrabajo(collamorator.getCargaTrabajo() + complement.getComplejidad());
                    colaboradoRepository.save(collamorator);
                    expedientesRepository.save(file);
                    this.updateState(28, noFile);
                    break;
                }
            } else {
                file.setNitProfesional(professional.getNit());
                SgeColaborador collamorator = colaboradoRepository.findById(professional.getNit()).orElse(null);
                collamorator.setCargaTrabajo(collamorator.getCargaTrabajo() + complement.getComplejidad());
                colaboradoRepository.save(collamorator);
                expedientesRepository.save(file);
                this.updateState(28, noFile);
            }
        }
        if (file.getNitProfesional() == null) {
            this.assignProfessional(noFile, limite - 1);
        }
    }

    /**
     * Metodo para asignar un colaborador segun su rol a un expediente
     *
     * @author Cristian Raguay (acdraguay)
     * @param noFile
     * @param rol
     * @since 28/06/2022
     */
    @Transactional
    public void AssignmentCentralizer(String noFile, String rol) {
        final SgeExpediente file = expedientesRepository.findById(noFile).orElse(null);
        BitacoraAsignacionColaboradorDTO dto = new BitacoraAsignacionColaboradorDTO();
        dto.setComentario("Se asigno el expediente al "+rol);
        dto.setIdEstado(file.getIdEstado());
        dto.setNit(colaboradorService.centralizer(rol));
        dto.setNoExpedienteTributa(noFile);
        colaboradorService.CrateHistoryAssignmentCollaborator(dto);
    }
    /**
     * Metodo para asignar un colaborador segun su rol y el tipo de tribunal a un expediente
     *
     * @author Cristian Raguay (acdraguay)
     * @param noFile
     * @param rol
     * @since 28/06/2022
     */
    @Transactional
    public void AssignmentCollaborator(String noFile, int rol) {
        final SgeExpediente file = expedientesRepository.findById(noFile).orElse(null);
        BitacoraAsignacionColaboradorDTO dto = new BitacoraAsignacionColaboradorDTO();
        dto.setIdEstado(file.getIdEstado());
        switch (rol) {
            case 1:
                dto.setNit(colaboradorService.CollaboratorRol(rol, file.getTipoRecurso()).get(0).getNit());
                dto.setComentario("Asignasion del Expediente a Secretaria");
                break;
            case 19:
                dto.setNit(file.getNitProfesional());
                dto.setComentario("Asignasion del Expediente al Profesional");
                break;
            case 20:
                dto.setNit(colaboradorService.collaboratorSupervisor(file.getNitProfesional()));
                dto.setComentario("Asignacion del Expediente al Supervisor");
                break;
            case 21:
                dto.setNit(colaboradorService.collaboratorSpecialist(file.getNitProfesional()));
                dto.setComentario("Asignacion del Expediente Especialista");
                break;
            case 45:
                dto.setNit(colaboradorService.centralizer("Recepcion"));
                dto.setComentario("Asignasion del Expediente a Recepcion");
                break;
        }
        dto.setNoExpedienteTributa(noFile);
        colaboradorService.CrateHistoryAssignmentCollaborator(dto);
    }
    
        /**
     * Metodo para asignar manualmentu un colaborador
     *
     * @author Cristian Raguay (acdraguay)
     * @param noFile
     * @param nit
     * @return file
     * @since 01/07/2022
     */
    @Transactional
    public SgeExpediente manualAssignment(String noFile, String nit){
        final SgeExpediente file = expedientesRepository.findById(noFile).orElse(null);
        file.setNitProfesional(nit);
        return expedientesRepository.save(file);
    }
    
        /**
     * Metodo para asignar un expediente a una agenda
     *
     * @author Cristian Raguay (acdraguay)
     * @param noFile
     * @param diary
     * @return file
     * @since 01/07/2022
     */
    @Transactional
    public SgeExpediente diaryAssignment(String noFile, String diary){
            final SgeExpediente file = expedientesRepository.findById(noFile).orElse(null);
            file.setIdAgenda(diary);
            return expedientesRepository.save(file);
    }
    
     /**
     * Metodo para asignar al profecional que confronta el proyecto de resulucion
     *
     * @author Cristian Raguay (acdraguay)
     * @param noFile
     * @param nit
     * @return file
     * @since 05/07/2022
     */
    @Transactional
    public SgeComplementoExpediente confrontationAssignment(String noFile, String nit){
        final SgeComplementoExpediente file = complentoExpedienteRepository.findById(noFile).orElse(null);
        file.setNitColaboradorConfronto(nit);
        return complentoExpedienteRepository.save(file);
    }
        /**
     * Metodo para asignar un colaborador segun su rol a un expediente
     *
     * @author Cristian Raguay (acdraguay)
     * @return receptionist
     * @since 05/07/2022
     */
    @Transactional(readOnly = true)
    public List<RecepcionistaProjection> receptionist(){
        return expedientesRepository.receptionist();
    }
    
    @Transactional(readOnly = true)
    public List<AsignacionManualProjection> coordinator(){
     return expedientesRepository.coordinator();
    }
}
