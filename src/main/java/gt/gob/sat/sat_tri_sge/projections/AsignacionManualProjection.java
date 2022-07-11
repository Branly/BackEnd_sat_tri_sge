/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.projections;

/**
 *
 * @author crist
 */
public interface AsignacionManualProjection {

    String getTipo_recurso();

    String getNit_contribuyente();

    String getGerencia_origen();

    Integer getFolios();

    String getNo_expediente_tributa();

    Integer getCantidad_ajustes();

    String getImpuestos();

    String getTipo_caso();

    String getSub_tipo_caso();
    
    String getNombre();
}
