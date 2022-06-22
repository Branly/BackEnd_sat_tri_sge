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

    String getNoExpedienteTributa();

    Integer getTipoRecurso();

    String getNit_contribuyente();

    Date getFecha_ingreso();

    String getGerencia_Origen();

    Integer getMonto();

    Date getFecha_interposicion();

    String getId_estado();

    String getNit_profesional();

    String getEspcialista();
    
}
