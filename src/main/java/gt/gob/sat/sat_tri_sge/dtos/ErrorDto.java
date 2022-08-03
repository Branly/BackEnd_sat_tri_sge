/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;

/**
 *
 * @author alexa
 */
@ApiModel(value = "Error")
@Getter
@Builder
public class ErrorDto {

    private final String param;
    private final Object value;
    private final String description;

}
