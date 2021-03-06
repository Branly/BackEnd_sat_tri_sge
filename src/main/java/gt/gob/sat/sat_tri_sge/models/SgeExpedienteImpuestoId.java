package gt.gob.sat.sat_tri_sge.models;
// Generated 21/07/2022 11:03:06 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SgeExpedienteImpuestoId generated by hbm2java
 */
@Embeddable
public class SgeExpedienteImpuestoId  implements java.io.Serializable {


     private int idImpuesto;
     private String noExpedienteTributa;

    public SgeExpedienteImpuestoId() {
    }

    public SgeExpedienteImpuestoId(int idImpuesto, String noExpedienteTributa) {
       this.idImpuesto = idImpuesto;
       this.noExpedienteTributa = noExpedienteTributa;
    }
   


    @Column(name="id_impuesto", nullable=false)
    public int getIdImpuesto() {
        return this.idImpuesto;
    }
    
    public void setIdImpuesto(int idImpuesto) {
        this.idImpuesto = idImpuesto;
    }


    @Column(name="no_expediente_tributa", nullable=false, length=50)
    public String getNoExpedienteTributa() {
        return this.noExpedienteTributa;
    }
    
    public void setNoExpedienteTributa(String noExpedienteTributa) {
        this.noExpedienteTributa = noExpedienteTributa;
    }




}


