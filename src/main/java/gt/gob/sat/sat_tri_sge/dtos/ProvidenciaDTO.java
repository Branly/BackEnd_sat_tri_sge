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

public class ProvidenciaDTO {

    private String idProvidencia;

    private Date fechaCreacion;

    private Integer tipoProvidencia;

    private Date fechaModifica;

    private String usuarioModifica;

    private String ipModifica;
    
    private Integer idTribunal;
}
