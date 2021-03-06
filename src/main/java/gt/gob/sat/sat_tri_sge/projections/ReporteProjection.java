/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.projections;

import java.util.Date;

/**
 *
 * @author crist
 */
public interface ReporteProjection {

    String getNo_expediente();

    String getTiporecurso();

    String getNit_contribuyente();

    Date getFecha_ingreso();

    String getGerencia_origen();

    String getObservacion();

    String getNo_expediente_tributa();

    Integer getComplejidad();

    Integer getCantidad_ajustes();

    String getImpuesto();

    Integer getMonto();

    String getTipocaso();

    String getSubtipo();

    Date getFecha_interposicion();

    String getEspecial();

    String getGerencia();

    String getDepartamento();

    String getComentario();

    Date getFecha_preinscripcion();

    String getEstado();

    String getProfesional();

    String getEspecialista();

    String getId_agenda();

    Date getFecha_creacion();
}
