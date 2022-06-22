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


public class ColaboradorDTO {
    private String nit;
     private Integer cargaTrabajo;
     private String correo;
     private Date fechaModifica;
     private int idEstado;
     private int idPuesto;
     private String ipModifica;
     private String nombre;
     private int tipoTributa;
     private String usuarioModifica;
     
}
