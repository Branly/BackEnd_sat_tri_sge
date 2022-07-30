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
 * SgeCatEstadoCatalogo generated by hbm2java
 */
@Entity
@Table(name="sge_cat_estado_catalogo"
    ,schema="sat_tri_sge"
)
public class SgeCatEstadoCatalogo  implements java.io.Serializable {


     private int codigoEstado;
     private String descripcion;
     private Date fechaModifica;
     private String ipModifica;
     private String nombre;
     private String usuarioModifica;

    public SgeCatEstadoCatalogo() {
    }

    public SgeCatEstadoCatalogo(int codigoEstado, String descripcion, Date fechaModifica, String ipModifica, String nombre, String usuarioModifica) {
       this.codigoEstado = codigoEstado;
       this.descripcion = descripcion;
       this.fechaModifica = fechaModifica;
       this.ipModifica = ipModifica;
       this.nombre = nombre;
       this.usuarioModifica = usuarioModifica;
    }
   
     @Id 

    
    @Column(name="codigo_estado", unique=true, nullable=false)
    public int getCodigoEstado() {
        return this.codigoEstado;
    }
    
    public void setCodigoEstado(int codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    
    @Column(name="descripcion", nullable=false, length=100)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_modifica", nullable=false, length=29)
    public Date getFechaModifica() {
        return this.fechaModifica;
    }
    
    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    
    @Column(name="ip_modifica", nullable=false, length=15)
    public String getIpModifica() {
        return this.ipModifica;
    }
    
    public void setIpModifica(String ipModifica) {
        this.ipModifica = ipModifica;
    }

    
    @Column(name="nombre", nullable=false, length=100)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="usuario_modifica", nullable=false, length=20)
    public String getUsuarioModifica() {
        return this.usuarioModifica;
    }
    
    public void setUsuarioModifica(String usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }




}


