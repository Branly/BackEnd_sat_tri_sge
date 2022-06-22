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
public class PrestamoDTO {

    private int idPrestamo;
    private String noExpedienteTributa;
    private int departamento;
    private int gerencia;
    private String nitSolicitante;
    private String comentario;
    private Date fechaSalida;
    private Date fechaEntrada;
    private String usuarioModifica;
    private Date fechaModifica;
    private String ipModifica;

}
