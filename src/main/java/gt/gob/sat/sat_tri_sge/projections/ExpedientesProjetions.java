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
public interface ExpedientesProjetions {

    String getNit_contribuyente();

    Date getFecha_ingreso();

    String getNo_expediente_tributa();

    String getEstado();

    Date getFecha_preincripcion();
    
    String getProfesional();

    String getNombre();
}
