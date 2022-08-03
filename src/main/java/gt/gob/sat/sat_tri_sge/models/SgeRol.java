package gt.gob.sat.sat_tri_sge.models;
// Generated 29/07/2022 12:58:29 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SgeRol generated by hbm2java
 */
@Entity
@Table(name="sge_rol"
    ,schema="sat_tri_sge"
)
public class SgeRol  implements java.io.Serializable {


     private int idRol;
     private String nombre;

    public SgeRol() {
    }

    public SgeRol(int idRol, String nombre) {
       this.idRol = idRol;
       this.nombre = nombre;
    }
   
     @Id 

    
    @Column(name="id_rol", unique=true, nullable=false)
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

