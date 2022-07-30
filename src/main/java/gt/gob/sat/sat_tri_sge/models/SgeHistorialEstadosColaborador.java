package gt.gob.sat.sat_tri_sge.models;
// Generated 29/07/2022 12:58:29 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SgeHistorialEstadosColaborador generated by hbm2java
 */
@Entity
@Table(name="sge_historial_estados_colaborador"
    ,schema="sat_tri_sge"
)
public class SgeHistorialEstadosColaborador  implements java.io.Serializable {


     private int idHistorial;
     private Date fechaModifica;
     private int idEstado;
     private String ipModifica;
     private String nitColaborador;
     private String usuarioModifica;

    public SgeHistorialEstadosColaborador() {
    }

    public SgeHistorialEstadosColaborador(int idHistorial, Date fechaModifica, int idEstado, String ipModifica, String nitColaborador, String usuarioModifica) {
       this.idHistorial = idHistorial;
       this.fechaModifica = fechaModifica;
       this.idEstado = idEstado;
       this.ipModifica = ipModifica;
       this.nitColaborador = nitColaborador;
       this.usuarioModifica = usuarioModifica;
    }
   
     @Id 

    
    @Column(name="id_historial", unique=true, nullable=false)
    public int getIdHistorial() {
        return this.idHistorial;
    }
    
    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_modifica", nullable=false, length=29)
    public Date getFechaModifica() {
        return this.fechaModifica;
    }
    
    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    
    @Column(name="id_estado", nullable=false)
    public int getIdEstado() {
        return this.idEstado;
    }
    
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    
    @Column(name="ip_modifica", nullable=false, length=15)
    public String getIpModifica() {
        return this.ipModifica;
    }
    
    public void setIpModifica(String ipModifica) {
        this.ipModifica = ipModifica;
    }

    
    @Column(name="nit_colaborador", nullable=false, length=16)
    public String getNitColaborador() {
        return this.nitColaborador;
    }
    
    public void setNitColaborador(String nitColaborador) {
        this.nitColaborador = nitColaborador;
    }

    
    @Column(name="usuario_modifica", nullable=false, length=50)
    public String getUsuarioModifica() {
        return this.usuarioModifica;
    }
    
    public void setUsuarioModifica(String usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }




}


