/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.dtos;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author crist
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)


public class GrupotrabajoDTO {
    
     private int idGrupo;
     private int estado;
     private Date fechaModifica;
     private String ipModifica;
     private String nitEncargado;
     private String nombre;
     private String usuarioModifica;
     private int tipoGrupo;
    
}
