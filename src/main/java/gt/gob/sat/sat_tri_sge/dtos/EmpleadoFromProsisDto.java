/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author abaestrad
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoFromProsisDto {
    
    private String nit;
    private String nombre;
    private String nombrePuesto;
    private String estado;
    private String login;
    private String correo;
    private Integer codigoGerencia;
    private String nombreGerencia;
    private Integer codigoUnidad;
    private String nombreUnidad;
    private String renglon;
    
    
}
