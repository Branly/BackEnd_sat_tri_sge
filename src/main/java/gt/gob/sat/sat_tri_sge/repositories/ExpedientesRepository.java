/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.repositories;

import gt.gob.sat.sat_tri_sge.models.SgeExpediente;
import gt.gob.sat.sat_tri_sge.projections.ExpedientesProjection;
import gt.gob.sat.sat_tri_sge.projections.ExpedientesProjetions;
import gt.gob.sat.sat_tri_sge.projections.ReporteProjection;
import gt.gob.sat.sat_tri_sge.projections.ResumenProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author crist
 */
public interface ExpedientesRepository extends CrudRepository<SgeExpediente, String> {

    //Query para mostrar la informacion a la presidenta
    @Query(value = "select se.no_expediente_tributa, scd2.nombre as Tipo_recurso, \n"
            + "se.nit_contribuyente, se.fecha_ingreso,\n"
            + "se.gerencia_origen, sc.fecha_interposicion, \n"
            + "si.monto, se.fecha_preincripcion, scd.nombre as Estado,\n"
            + "sco.nombre as Profecional, sco2.nombre as Supervisor\n"
            + "from sat_tri_sge.sge_expediente se\n"
            + "left join sat_tri_sge.sge_complemento_expediente sc on se.no_expediente_tributa = sc.no_expediente_tributa\n"
            + "left join sat_tri_sge.sge_expediente_impuesto si on si.no_expediente_tributa = se.no_expediente_tributa\n"
            + "left join sat_tri_sge.sge_integrante_grupo sig on sig.nit = se.nit_profesional\n"
            + "left join sat_tri_sge.sge_grupo_trabjo sgt on sgt.id_grupo = sig.id_grupo\n"
            + "left join sat_tri_sge.sge_cat_dato scd on scd.codigo = se.id_estado\n"
            + "left join sat_tri_sge.sge_colaborador sco on sco.nit = se.nit_profesional\n"
            + "left join sat_tri_sge.sge_colaborador sco2 on sco2.nit = sgt.nit_encargado\n"
            + "left join sat_tri_sge.sge_cat_dato scd2 on scd2.codigo = se.tipo_recurso", nativeQuery = true)
    List<ExpedientesProjection> Expedientes();

    //Query general para las vistas de los Colaboradores
    @Query(value = "select se.nit_contribuyente,\n"
            + "            se.fecha_ingreso,\n"
            + "            se.no_expediente_tributa,\n"
            + "            scd.nombre as estado,\n"
            + "            se.fecha_preincripcion,\n"
            + "            sc.nombre \n"
            + "            from sat_tri_sge.sge_expediente se \n"
            + "            inner join sat_tri_sge.sge_cat_dato scd on se.id_estado = scd.codigo \n"
            + "            inner join sat_tri_sge.sge_colaborador sc on sc.nit = se.nit_profesional \n"
            + "            inner join sat_tri_sge.sge_bitacora_asignacion_colaborador bc on bc.no_expediente_tributa = se.no_expediente_tributa\n"
            + "            where bc.nit = :nit and se.id_estado in (:estados)", nativeQuery = true)
    List<ExpedientesProjetions> getFiles(@Param("nit") String nit, @Param("estados") List<Integer> estados);

    //query para el reporte mensual
    @Query(value = "select se.no_expediente, scd9.nombre as TipoRecurso,\n"
            + "se.nit_contribuyente, se.fecha_ingreso, se.gerencia_origen, scd2.nombre  as Observacion, se.no_expediente_tributa,\n"
            + "sce.complejidad, se.cantidad_ajustes, scd4.nombre as Impuesto, sei.monto, scd3.nombre as TipoCaso,\n"
            + "scd.nombre as SubTipo, sce.fecha_interposicion , scd5.nombre as Especial, scd6.nombre as Gerencia , \n"
            + "scd7.nombre as Departamento, sp.comentario,\n"
            + "se.fecha_preincripcion as Fecha_preinscripcion, scd8.nombre as Estado, sc2.nombre as Profesional, sc.nombre as Especialista, \n"
            + "se.id_agenda, sa.fecha_creacion\n"
            + "from sat_tri_sge.sge_expediente se\n"
            + "left join sat_tri_sge.sge_observacion so on so.no_expediente_tributa = se.no_expediente_tributa\n"
            + "left join sat_tri_sge.sge_cat_dato scd2 on so.observaciones = scd2.codigo\n"
            + "left join sat_tri_sge.sge_complemento_expediente sce on sce.no_expediente_tributa = se.no_expediente_tributa\n"
            + "left join sat_tri_sge.sge_expediente_impuesto sei on sei.no_expediente_tributa = se.no_expediente_tributa\n"
            + "left join sat_tri_sge.sge_cat_dato scd3 on scd3.codigo = sce.tipo_caso \n"
            + "left join sat_tri_sge.sge_cat_dato scd on scd.codigo = sce.sub_tipo_caso\n"
            + "left join sat_tri_sge.sge_cat_dato scd4 on scd4.codigo = sei.id_impuesto \n"
            + "left join sat_tri_sge.sge_cat_dato scd5 on scd5.codigo = sce.id_caso_especial\n"
            + "left join sat_tri_sge.sge_prestamo sp on sp.no_expediente_tributa = se.no_expediente_tributa\n"
            + "left join sat_tri_sge.sge_integrante_grupo sig on sig.nit = se.nit_profesional\n"
            + "left join sat_tri_sge.sge_grupo_trabjo sgt on sig.id_grupo = sgt.id_grupo\n"
            + "left join sat_tri_sge.sge_colaborador sc on sgt.nit_encargado = sc.nit\n"
            + "left join sat_tri_sge.sge_agenda sa on sa.id_agenda = se.id_agenda\n"
            + "left join sat_tri_sge.sge_colaborador sc2 on sc2.nit = se.nit_profesional\n"
            + "left join sat_tri_sge.sge_cat_dato scd6 on scd6.codigo = sp.gerencia\n"
            + "left join sat_tri_sge.sge_cat_dato scd7 on scd7.codigo = sp.departamento\n"
            + "left join sat_tri_sge.sge_cat_dato scd8 on scd8.codigo = se.id_estado\n"
            + "left join sat_tri_sge.sge_cat_dato scd9 on scd9.codigo = se.tipo_recurso\n"
            + "where (extract(year from se.fecha_ingreso)) = :anio and (extract(month from se.fecha_ingreso)) = :mes", nativeQuery = true)
    List<ReporteProjection> Report(@Param("anio") int anio, @Param("mes") int mes);

    //Query para los espedientes de una agenda
    @Query(value = "select se.nit_contribuyente,\n"
            + "se.fecha_ingreso,\n"
            + "se.no_expediente_tributa,\n"
            + "scd.nombre as estado,\n"
            + "se.fecha_preincripcion,\n"
            + "sc.nombre \n"
            + "from sat_tri_sge.sge_expediente se \n"
            + "inner join sat_tri_sge.sge_cat_dato scd on se.id_estado = scd.codigo \n"
            + "inner join sat_tri_sge.sge_colaborador sc on sc.nit = se.nit_profesional \n"
            + "where se.id_agenda = :agenda", nativeQuery = true)
    List<ExpedientesProjetions> DiaryFiles(@Param("agenda") String agenda);

    //Query para obtenr los resumenes para la agenda
    @Query(value = "select se.nit_contribuyente, se.no_expediente, sr.resumen, sr.resolucion, sc.nombre  from sat_tri_sge.sge_expediente se\n"
            + "left join sat_tri_sge.sge_resumen sr on sr.no_expediente_tributa = se.no_expediente_tributa\n"
            + "left join sat_tri_sge.sge_integrante_grupo sig on sig.nit = se.nit_profesional\n"
            + "left join sat_tri_sge.sge_grupo_trabjo sgt on sgt.id_grupo = sig.id_grupo\n"
            + "left join sat_tri_sge.sge_colaborador sc on sc.nit = sgt.nit_encargado\n"
            + "where se.id_agenda = :agenda", nativeQuery = true)
    List<ResumenProjection> Resum(@Param("agenda") String agenda);


}
