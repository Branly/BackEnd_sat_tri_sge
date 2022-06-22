/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.services;

import gt.gob.sat.arquitectura.microservices.config.request.Detector;
import gt.gob.sat.sat_tri_sge.dtos.AnexoDTO;
import gt.gob.sat.sat_tri_sge.dtos.ComplementoExpedienteDTO;
import gt.gob.sat.sat_tri_sge.dtos.ExpedienteImpuestoDTO;
import gt.gob.sat.sat_tri_sge.dtos.ExpedientesDTO;
import gt.gob.sat.sat_tri_sge.dtos.ObservacionDTO;
import gt.gob.sat.sat_tri_sge.dtos.PrestamoDTO;
import gt.gob.sat.sat_tri_sge.dtos.ResumenDTO;
import gt.gob.sat.sat_tri_sge.models.SgeAnexo;
import gt.gob.sat.sat_tri_sge.models.SgeComplementoExpediente;
import gt.gob.sat.sat_tri_sge.models.SgeExpediente;
import gt.gob.sat.sat_tri_sge.models.SgeExpedienteImpuesto;
import gt.gob.sat.sat_tri_sge.models.SgeExpedienteImpuestoId;
import gt.gob.sat.sat_tri_sge.models.SgeObservacion;
import gt.gob.sat.sat_tri_sge.models.SgePrestamo;
import gt.gob.sat.sat_tri_sge.models.SgeResumen;
import gt.gob.sat.sat_tri_sge.projections.ExpedientesProjection;
import gt.gob.sat.sat_tri_sge.projections.ExpedientesProjetions;
import gt.gob.sat.sat_tri_sge.projections.ReporteProjection;
import gt.gob.sat.sat_tri_sge.repositories.AnexoRepository;
import gt.gob.sat.sat_tri_sge.repositories.ComplementoExpedienteRepository;
import gt.gob.sat.sat_tri_sge.repositories.ExpedienteImpuestoRepository;
import gt.gob.sat.sat_tri_sge.repositories.ExpedientesRepository;
import gt.gob.sat.sat_tri_sge.repositories.ObservacionRepository;
import gt.gob.sat.sat_tri_sge.repositories.PrestamoRepository;
import gt.gob.sat.sat_tri_sge.repositories.ResumenRepository;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.operator.AADProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

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

    @Transactional(readOnly = true)
    public List<ExpedientesProjection> getFiles() {
        log.debug("Obteniendo Expedientes");
        return expedientesRepository.Expedientes();
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
        complementCreate.setTipoCaso(dto.getTipoCaso());
        complementCreate.setSubTipoCaso(dto.getSubTipoCaso());
        complementCreate.setFechaInterposicion(dto.getFechaInterposicion());
        complementCreate.setIdCasoEspecial(dto.getIdCasoEspecial());
        return complentoExpedienteRepository.save(complementCreate);
    }

    /**
     * Metodo para actualizar el estado de un Expediente
     *
     * @author Cristian Raguay (acdraguay)
     * @param dto
     * @param noExpedienteTributa
     * @since 14/06/2022
     * @return updateState
     */
    @Transactional
    public SgeExpediente updateState(ExpedientesDTO dto, String noExpedienteTributa) {
        final SgeExpediente updateState = expedientesRepository.findById(noExpedienteTributa).orElse(null);
        updateState.setIdEstado(dto.getIdEstado());
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

 
    @Transactional
    public SgeResumen CreateResumen(ResumenDTO dto){
        final SgeResumen resumenCreate = new SgeResumen();
        resumenCreate.setFechaModifica(new Date());
        resumenCreate.setIpModifica(detector.getIp());
        resumenCreate.setNoExpedienteTributa(dto.getNoExpedienteTributa());
        resumenCreate.setResolucion(dto.getResolucion());
        resumenCreate.setResumen(dto.getResumen());
        resumenCreate.setSentido(dto.getSentido());
        resumenCreate. setUsuarioModifica(detector.getLogin());
        return resumenRepository.save(resumenCreate);
    }
    
    @Transactional
    public SgeResumen UpdateResumen(ResumenDTO dto){
        final SgeResumen resumenCreate = resumenRepository.findById(dto.getIdResumen()).orElse(null);
        resumenCreate.setFechaModifica(new Date());
        resumenCreate.setIpModifica(detector.getIp());
        resumenCreate.setResolucion(dto.getResolucion());
        resumenCreate.setResumen(dto.getResumen());
        resumenCreate.setSentido(dto.getSentido());
        resumenCreate. setUsuarioModifica(detector.getLogin());
        return resumenRepository.save(resumenCreate);
    }
    
    @Transactional(readOnly = true)
    public List<ReporteProjection> Report(){
        return expedientesRepository.Report();
    }
    
}
