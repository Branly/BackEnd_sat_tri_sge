/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.dtos;

import java.util.List;
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
public class AllowedUriDto {
    
    private String uri;
    private List<String> httpsMethods;
    
}
