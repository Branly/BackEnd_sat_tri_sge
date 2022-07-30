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
    private int idGerencia;
    private String iniciales;
    private String ipModifica;
    private String login;
    private String nombre;
    private String puestoTrabajo;
    private int tipoTributa;
    private String usuarioModifica;

}
