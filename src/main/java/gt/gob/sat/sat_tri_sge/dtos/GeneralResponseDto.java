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
 * @author abaestrad
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeneralResponseDto<T> {
 
        /**
     * mensaje de la respuesta.
     */
    private String message;
    /**
     * Codigo de la respuesta.
     */
    private int code;
    /**
     * Tipo de respuesta.
     */
    private String type;
    /**
     * Detalles de la operacion.
     */
    private T data;
    
}
