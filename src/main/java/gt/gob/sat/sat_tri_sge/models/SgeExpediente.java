package gt.gob.sat.sat_tri_sge.models;
// Generated 29/07/2022 02:30:03 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SgeExpediente generated by hbm2java
 */
@Entity
@Table(name="sge_expediente"
    ,schema="sat_tri_sge"
)
public class SgeExpediente  implements java.io.Serializable {


     private String noExpedienteTributa;
     private int tipoRecurso;
     private int idEstado;
     private String idAgenda;
     private String nitProfesional;
     private String nitContribuyente;
     private int idGerenciaOrigen;
     private String direccionFiscal;
     private String noExpediente;
     private int folios;
     private int cantidadAjustes;
     private long idProces;
     private Date fechaIngreso;
     private Date fechaPreincripcion;
     private String usuarioModifica;
     private Date fechaModifica;
     private String ipModifica;
     private String resolucionEntrada;
     private String resolucionSalida;
     private String nombre;

    public SgeExpediente() {
    }

	
    public SgeExpediente(String noExpedienteTributa, int tipoRecurso, int idEstado, String nitContribuyente, int idGerenciaOrigen, String direccionFiscal, String noExpediente, int folios, int cantidadAjustes, long idProces, Date fechaIngreso, String usuarioModifica, Date fechaModifica, String ipModifica, String nombre) {
        this.noExpedienteTributa = noExpedienteTributa;
        this.tipoRecurso = tipoRecurso;
        this.idEstado = idEstado;
        this.nitContribuyente = nitContribuyente;
        this.idGerenciaOrigen = idGerenciaOrigen;
        this.direccionFiscal = direccionFiscal;
        this.noExpediente = noExpediente;
        this.folios = folios;
        this.cantidadAjustes = cantidadAjustes;
        this.idProces = idProces;
        this.fechaIngreso = fechaIngreso;
        this.usuarioModifica = usuarioModifica;
        this.fechaModifica = fechaModifica;
        this.ipModifica = ipModifica;
        this.nombre = nombre;
    }
    public SgeExpediente(String noExpedienteTributa, int tipoRecurso, int idEstado, String idAgenda, String nitProfesional, String nitContribuyente, int idGerenciaOrigen, String direccionFiscal, String noExpediente, int folios, int cantidadAjustes, long idProces, Date fechaIngreso, Date fechaPreincripcion, String usuarioModifica, Date fechaModifica, String ipModifica, String resolucionEntrada, String resolucionSalida, String nombre) {
       this.noExpedienteTributa = noExpedienteTributa;
       this.tipoRecurso = tipoRecurso;
       this.idEstado = idEstado;
       this.idAgenda = idAgenda;
       this.nitProfesional = nitProfesional;
       this.nitContribuyente = nitContribuyente;
       this.idGerenciaOrigen = idGerenciaOrigen;
       this.direccionFiscal = direccionFiscal;
       this.noExpediente = noExpediente;
       this.folios = folios;
       this.cantidadAjustes = cantidadAjustes;
       this.idProces = idProces;
       this.fechaIngreso = fechaIngreso;
       this.fechaPreincripcion = fechaPreincripcion;
       this.usuarioModifica = usuarioModifica;
       this.fechaModifica = fechaModifica;
       this.ipModifica = ipModifica;
       this.resolucionEntrada = resolucionEntrada;
       this.resolucionSalida = resolucionSalida;
       this.nombre = nombre;
    }
   
     @Id 

    
    @Column(name="no_expediente_tributa", unique=true, nullable=false, length=50)
    public String getNoExpedienteTributa() {
        return this.noExpedienteTributa;
    }
    
    public void setNoExpedienteTributa(String noExpedienteTributa) {
        this.noExpedienteTributa = noExpedienteTributa;
    }

    
    @Column(name="tipo_recurso", nullable=false)
    public int getTipoRecurso() {
        return this.tipoRecurso;
    }
    
    public void setTipoRecurso(int tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    
    @Column(name="id_estado", nullable=false)
    public int getIdEstado() {
        return this.idEstado;
    }
    
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    
    @Column(name="id_agenda", length=50)
    public String getIdAgenda() {
        return this.idAgenda;
    }
    
    public void setIdAgenda(String idAgenda) {
        this.idAgenda = idAgenda;
    }

    
    @Column(name="nit_profesional", length=16)
    public String getNitProfesional() {
        return this.nitProfesional;
    }
    
    public void setNitProfesional(String nitProfesional) {
        this.nitProfesional = nitProfesional;
    }

    
    @Column(name="nit_contribuyente", nullable=false, length=16)
    public String getNitContribuyente() {
        return this.nitContribuyente;
    }
    
    public void setNitContribuyente(String nitContribuyente) {
        this.nitContribuyente = nitContribuyente;
    }

    
    @Column(name="id_gerencia_origen", nullable=false)
    public int getIdGerenciaOrigen() {
        return this.idGerenciaOrigen;
    }
    
    public void setIdGerenciaOrigen(int idGerenciaOrigen) {
        this.idGerenciaOrigen = idGerenciaOrigen;
    }

    
    @Column(name="direccion_fiscal", nullable=false, length=100)
    public String getDireccionFiscal() {
        return this.direccionFiscal;
    }
    
    public void setDireccionFiscal(String direccionFiscal) {
        this.direccionFiscal = direccionFiscal;
    }

    
    @Column(name="no_expediente", nullable=false, length=50)
    public String getNoExpediente() {
        return this.noExpediente;
    }
    
    public void setNoExpediente(String noExpediente) {
        this.noExpediente = noExpediente;
    }

    
    @Column(name="folios", nullable=false)
    public int getFolios() {
        return this.folios;
    }
    
    public void setFolios(int folios) {
        this.folios = folios;
    }

    
    @Column(name="cantidad_ajustes", nullable=false)
    public int getCantidadAjustes() {
        return this.cantidadAjustes;
    }
    
    public void setCantidadAjustes(int cantidadAjustes) {
        this.cantidadAjustes = cantidadAjustes;
    }

    
    @Column(name="id_proces", nullable=false)
    public long getIdProces() {
        return this.idProces;
    }
    
    public void setIdProces(long idProces) {
        this.idProces = idProces;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_ingreso", nullable=false, length=29)
    public Date getFechaIngreso() {
        return this.fechaIngreso;
    }
    
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_preincripcion", length=29)
    public Date getFechaPreincripcion() {
        return this.fechaPreincripcion;
    }
    
    public void setFechaPreincripcion(Date fechaPreincripcion) {
        this.fechaPreincripcion = fechaPreincripcion;
    }

    
    @Column(name="usuario_modifica", nullable=false, length=20)
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

    
    @Column(name="ip_modifica", nullable=false, length=15)
    public String getIpModifica() {
        return this.ipModifica;
    }
    
    public void setIpModifica(String ipModifica) {
        this.ipModifica = ipModifica;
    }

    
    @Column(name="resolucion_entrada", length=100)
    public String getResolucionEntrada() {
        return this.resolucionEntrada;
    }
    
    public void setResolucionEntrada(String resolucionEntrada) {
        this.resolucionEntrada = resolucionEntrada;
    }

    
    @Column(name="resolucion_salida", length=100)
    public String getResolucionSalida() {
        return this.resolucionSalida;
    }
    
    public void setResolucionSalida(String resolucionSalida) {
        this.resolucionSalida = resolucionSalida;
    }

    
    @Column(name="nombre", nullable=false, length=200)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




}


