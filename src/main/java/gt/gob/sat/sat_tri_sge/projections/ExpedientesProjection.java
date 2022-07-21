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
public interface ExpedientesProjection {

    String getNo_expediente();

    String getTipo_recurso();

    String getNit_contribuyente();
    
    String getNombre();

    Date getFecha_ingreso();

    String getGerencia_origen();

    Date getFecha_interposicion();
    
    String getRecurso();
    
    Integer getMonto();

    Date getFecha_preincripcion();
    
    String getEstado();

    String getProfesional();

    String getEspecialista();
    
    String getId_agenda();
    
    Integer getFolios();
    
    String getDireccion_fiscal();
    
    Integer getCantidad_ajustes();
    
    String getObservacion();
    
    String getImpuesto();
    
    String getTipo_caso();
    
    String getSubTipo_caso();
    
    String getNo_expediente_tributa();
}
