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
public interface RecepcionistaProjection {

    String getNo_expediente();

    String getTipo_recurso();

    String getNombre();

    String getNit_contribuyente();

    Date getFecha_ingreso();

    String getGerencia_origen();

    Integer getFolios();

    String getNo_expediente_tributa();

    String getRecurso();

    String getDireccion_fiscal();

    Integer getCantidad_ajustes();
    
    String getObsevacion();
}
