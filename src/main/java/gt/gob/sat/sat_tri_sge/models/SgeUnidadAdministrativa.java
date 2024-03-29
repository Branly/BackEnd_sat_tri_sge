package gt.gob.sat.sat_tri_sge.models;
// Generated 29/07/2022 12:59:41 PM by Hibernate Tools 4.3.1

import gt.gob.sat.sat_tri_sge.dtos.UnidadAdministrativaDto;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SgeUnidadAdministrativa generated by hbm2java
 */
@Entity
@Table(name="sge_unidad_administrativa"
    ,schema="sat_tri_sge"
)
public class SgeUnidadAdministrativa  implements java.io.Serializable {

     private long id;
     private String nombre;
     private String descripcion;
     private String usuarioModifica;
     private Date fechaModifica;
     private Long idPadre;
     private Integer idEstado;
     private String ipModifica;
     private Integer idUnidadProsis;

    public SgeUnidadAdministrativa() {
    }
	
    public SgeUnidadAdministrativa(long id, String nombre, Date fechaModifica, String ipModifica) {
        this.id = id;
        this.nombre = nombre;
        this.fechaModifica = fechaModifica;
        this.ipModifica = ipModifica;
    }
    
    public SgeUnidadAdministrativa(long id, String nombre, String descripcion, String usuarioModifica, Date fechaModifica, Long idPadre, Integer idEstado, String ipModifica, Integer idUnidadProsis) {
       this.id = id;
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.usuarioModifica = usuarioModifica;
       this.fechaModifica = fechaModifica;
       this.idPadre = idPadre;
       this.idEstado = idEstado;
       this.ipModifica = ipModifica;
       this.idUnidadProsis = idUnidadProsis;
    }
    
         public SgeUnidadAdministrativa(String nombre, String descripcion, String usuarioModifica, Date fechaModifica, Long idPadre, Integer idEstado, String ipModifica, Integer idUnidadProsis) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.usuarioModifica = usuarioModifica;
        this.fechaModifica = fechaModifica;
        this.idPadre = idPadre;
        this.idEstado = idEstado;
        this.ipModifica = ipModifica;
        this.idUnidadProsis = idUnidadProsis;
    }

    public SgeUnidadAdministrativa(UnidadAdministrativaDto unit) {
        this.nombre = unit.getNombre();
        this.descripcion = unit.getDescripcion();
        this.idPadre = unit.getIdPadre();
        this.idEstado = unit.getIdEstado();
    }
   
     @Id 
    @Column(name="id", unique=true, nullable=false, updatable = false, insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    @Column(name="nombre", nullable=false, length=200)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name="descripcion", length=400)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name="usuario_modifica", length=20)
    public String getUsuarioModifica() {
        return this.usuarioModifica;
    }
    
    public void setUsuarioModifica(String usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_modifica", nullable=false, length=29)
    public Date getFechaModifica() {
        return this.fechaModifica;
    }
    
    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    @Column(name="id_padre")
    public Long getIdPadre() {
        return this.idPadre;
    }
    
    public void setIdPadre(Long idPadre) {
        this.idPadre = idPadre;
    }

    @Column(name="id_estado")
    public Integer getIdEstado() {
        return this.idEstado;
    }
    
    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }
    
    @Column(name="ip_modifica", nullable=false, length=40)
    public String getIpModifica() {
        return this.ipModifica;
    }
    
    public void setIpModifica(String ipModifica) {
        this.ipModifica = ipModifica;
    }

    @Column(name="id_unidad_prosis", nullable=true)
    public Integer getIdUnidadProsis() {
        return this.idUnidadProsis;
    }
    
    public void setIdUnidadProsis(Integer idUnidadProsis) {
        this.idUnidadProsis = idUnidadProsis;
    }
}
