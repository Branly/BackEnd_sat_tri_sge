package gt.gob.sat.sat_tri_sge.models;
// Generated 29/07/2022 12:58:29 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SgeCatCatalogo generated by hbm2java
 */
@Entity
@Table(name="sge_cat_catalogo"
    ,schema="sat_tri_sge"
)
public class SgeCatCatalogo  implements java.io.Serializable {


     private int codigo;
     private String descripcion;
     private int estado;
     private Date fechaAgrega;
     private Date fechaModifica;
     private String nombre;
     private SgeCatCatalogo sgeCatCatalogo;
     private Set<SgeCatCatalogo> sgeCatCatalogos = new HashSet<SgeCatCatalogo>(0);
     private String usuarioAgrega;
     private String usuarioModifica;

    public SgeCatCatalogo() {
    }

	
    public SgeCatCatalogo(int codigo, String descripcion, int estado, Date fechaAgrega, Date fechaModifica, String nombre, String usuarioAgrega, String usuarioModifica) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaAgrega = fechaAgrega;
        this.fechaModifica = fechaModifica;
        this.nombre = nombre;
        this.usuarioAgrega = usuarioAgrega;
        this.usuarioModifica = usuarioModifica;
    }
    public SgeCatCatalogo(int codigo, String descripcion, int estado, Date fechaAgrega, Date fechaModifica, String nombre, SgeCatCatalogo sgeCatCatalogo, Set<SgeCatCatalogo> sgeCatCatalogos, String usuarioAgrega, String usuarioModifica) {
       this.codigo = codigo;
       this.descripcion = descripcion;
       this.estado = estado;
       this.fechaAgrega = fechaAgrega;
       this.fechaModifica = fechaModifica;
       this.nombre = nombre;
       this.sgeCatCatalogo = sgeCatCatalogo;
       this.sgeCatCatalogos = sgeCatCatalogos;
       this.usuarioAgrega = usuarioAgrega;
       this.usuarioModifica = usuarioModifica;
    }
   
     @Id 

    
    @Column(name="codigo", unique=true, nullable=false)
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    
    @Column(name="descripcion", nullable=false, length=200)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    @Column(name="estado", nullable=false)
    public int getEstado() {
        return this.estado;
    }
    
    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_agrega", nullable=false, length=29)
    public Date getFechaAgrega() {
        return this.fechaAgrega;
    }
    
    public void setFechaAgrega(Date fechaAgrega) {
        this.fechaAgrega = fechaAgrega;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_modifica", nullable=false, length=29)
    public Date getFechaModifica() {
        return this.fechaModifica;
    }
    
    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    
    @Column(name="nombre", nullable=false, length=50)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="codigo_cat_padre")
    public SgeCatCatalogo getSgeCatCatalogo() {
        return this.sgeCatCatalogo;
    }
    
    public void setSgeCatCatalogo(SgeCatCatalogo sgeCatCatalogo) {
        this.sgeCatCatalogo = sgeCatCatalogo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="sgeCatCatalogo")
    public Set<SgeCatCatalogo> getSgeCatCatalogos() {
        return this.sgeCatCatalogos;
    }
    
    public void setSgeCatCatalogos(Set<SgeCatCatalogo> sgeCatCatalogos) {
        this.sgeCatCatalogos = sgeCatCatalogos;
    }

    
    @Column(name="usuario_agrega", nullable=false, length=50)
    public String getUsuarioAgrega() {
        return this.usuarioAgrega;
    }
    
    public void setUsuarioAgrega(String usuarioAgrega) {
        this.usuarioAgrega = usuarioAgrega;
    }

    
    @Column(name="usuario_modifica", nullable=false, length=20)
    public String getUsuarioModifica() {
        return this.usuarioModifica;
    }
    
    public void setUsuarioModifica(String usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }




}


