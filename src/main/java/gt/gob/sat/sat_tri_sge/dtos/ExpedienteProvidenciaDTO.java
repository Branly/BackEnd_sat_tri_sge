/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.dtos;

import gt.gob.sat.sat_tri_sge.models.SgeExpedienteProvidenciaId;
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

public class ExpedienteProvidenciaDTO {
    private String idProvidencia;

    private String noexpediente;

    private String comentario;

    private String resolucion;

    private Date fechaModifica;

    private String usuarioModifica;

    private String ipModifica;
}
