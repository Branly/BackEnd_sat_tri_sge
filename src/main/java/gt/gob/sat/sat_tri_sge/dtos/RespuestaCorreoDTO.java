/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.dtos;

/**
 *
 * @author crist
 */
public class RespuestaCorreoDTO {
    /**
     * Serial de la clase.
     */
    private static final long serialVersionUID = 1L;

    private String tipo;
    private int codigo;
    private String mensaje;
    private boolean envioEmail;

    /**
     * Crea una nueva instancia de <code>RespuestaWSDto</code>.
     */
    public RespuestaCorreoDTO() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isEnvioEmail() {
        return envioEmail;
    }

    public void setEnvioEmail(boolean envioEmail) {
        this.envioEmail = envioEmail;
    }
}
