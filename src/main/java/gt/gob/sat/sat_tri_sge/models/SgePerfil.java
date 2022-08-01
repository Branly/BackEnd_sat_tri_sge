package gt.gob.sat.sat_tri_sge.models;
// Generated 29/07/2022 12:58:29 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SgePerfil generated by hbm2java
 */
@Entity
@Table(name="sge_perfil"
    ,schema="sat_tri_sge"
)
public class SgePerfil  implements java.io.Serializable {


     private int idPerfil;
     private int estado;
     private int idRol;
     private String nombre;

    public SgePerfil() {
    }

    public SgePerfil(int idPerfil, int estado, int idRol, String nombre) {
       this.idPerfil = idPerfil;
       this.estado = estado;
       this.idRol = idRol;
       this.nombre = nombre;
    }
   
     @Id 

    
    @Column(name="id_perfil", unique=true, nullable=false)
    public int getIdPerfil() {
        return this.idPerfil;
    }
    
    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    
    @Column(name="estado", nullable=false)
    public int getEstado() {
        return this.estado;
    }
    
    public void setEstado(int estado) {
        this.estado = estado;
    }

    
    @Column(name="id_rol", nullable=false)
    public int getIdRol() {
        return this.idRol;
    }
    
    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    
    @Column(name="nombre", nullable=false, length=200)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




}


