/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author alexa
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UnidadAdministrativaDto {
    
    private String nombre;
    private String descripcion;
    private Long idPadre;
    private Integer idEstado;
    
}
