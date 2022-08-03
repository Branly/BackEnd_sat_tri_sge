package gt.gob.sat.sat_tri_sge.models;
// Generated 29/07/2022 12:58:29 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SgePerfilFuncionId generated by hbm2java
 */
@Embeddable
public class SgePerfilFuncionId  implements java.io.Serializable {


     private String idOpcionMenu;
     private int idPerfil;

    public SgePerfilFuncionId() {
    }

    public SgePerfilFuncionId(String idOpcionMenu, int idPerfil) {
       this.idOpcionMenu = idOpcionMenu;
       this.idPerfil = idPerfil;
    }
   


    @Column(name="id_opcion_menu", nullable=false, length=4)
    public String getIdOpcionMenu() {
        return this.idOpcionMenu;
    }
    
    public void setIdOpcionMenu(String idOpcionMenu) {
        this.idOpcionMenu = idOpcionMenu;
    }


    @Column(name="id_perfil", nullable=false)
    public int getIdPerfil() {
        return this.idPerfil;
    }
    
    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }




}

