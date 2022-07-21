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

public class ExpedientesDTO {
    
    private String noExpedienteTributa;
     private int cantidadAjustes;
     private String direccionFiscal;
     private Date fechaIngreso;
     private Date fechaModifica;
     private Date fechaPreincripcion;
     private int folios;
     private int IdGerenciaOrigen;
     private String idAgenda;
     private int idEstado;
     private long idProces;
     private String ipModifica;
     private String nitContribuyente;
     private String nitProfesional;
     private String noExpediente;
     private int tipoRecurso;
     private String usuarioModifica;
     private String resolucionEntrada;
}
