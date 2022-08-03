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

public class AgendaDTO {

    private String idAgenda;
    private String asuntoAgenda;
    private Date fechaCreacion;
    private Date fechaModifica;
    private String ipModifica;
    private int tipoAgenda;
    private String usuarioModifica;
}