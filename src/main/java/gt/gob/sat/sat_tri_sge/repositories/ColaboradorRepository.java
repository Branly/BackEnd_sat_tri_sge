/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.repositories;

import gt.gob.sat.sat_tri_sge.models.SgeColaborador;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import gt.gob.sat.sat_tri_sge.projections.ColaboradorProjection;

/**
 *
 * @author crist
 */
public interface ColaboradorRepository extends CrudRepository<SgeColaborador, String> {

    //Query para traer a un colaborador en base a su nit.
    @Query(value = "select  sc.nit, \n"
            + "sc.nombre, \n"
            + "sd.nombre as Estado, \n"
            + "sdos.nombre as Puesto, \n"
            + "scd.nombre as Tipo_Tributa, \n"
            + "sc.correo from sat_tri_sge.sge_colaborador sc\n"
            + "left join sat_tri_sge.sge_cat_dato sd on sc.id_estado = sd.codigo\n"
            + "left join sat_tri_sge.sge_cat_dato sdos on sc.id_puesto = sdos.codigo\n"
            + "left join sat_tri_sge.sge_cat_dato scd on sc.tipo_tributa = scd.codigo\n"
            + "where sc.nit = :nit", nativeQuery = true)
    List<ColaboradorProjection> Colaborador(@Param("nit") String nit);

    //Query para traer a todos los colaboradores
    @Query(value = "select  sc.nit, \n"
            + "sc.nombre, \n"
            + "sd.nombre as Estado, \n"
            + "sdos.nombre as Puesto, \n"
            + "scd.nombre as Tipo_Tributa, \n"
            + "sc.correo from sat_tri_sge.sge_colaborador sc\n"
            + "left join sat_tri_sge.sge_cat_dato sd on sc.id_estado = sd.codigo\n"
            + "left join sat_tri_sge.sge_cat_dato sdos on sc.id_puesto = sdos.codigo\n"
            + "left join sat_tri_sge.sge_cat_dato scd on sc.tipo_tributa = scd.codigo\n", nativeQuery = true)
    List<ColaboradorProjection> Colaboradores();

    //Query para traer listas de Colaboradores Segun su Rol
    @Query(value = "select sc.nombre, sc.nit from sat_tri_sge.sge_colaborador sc\n"
            + "left join sat_tri_sge.sge_cat_dato scd on sc.id_puesto = scd.codigo\n"
            + "where sc.id_puesto = :rol and sc.tipo_tributa = :tipo", nativeQuery = true)
    List<ColaboradorProjection> collaboratorsRol(@Param("rol") int rol, @Param("tipo") int tipo);

    //Query que trae el nit de un centralizador
    @Query(value = "select sc.nit from sat_tri_sge.sge_colaborador sc\n"
            + "inner join sat_tri_sge.sge_cat_dato scd on sc.id_puesto = scd.codigo\n"
            + "where scd.nombre = :rol", nativeQuery = true)
    String Centralizer(@Param("rol") String rol);

    //Query para obtener al supervisor de un profecional
    @Query(value = "select sig.nit_supervisor  from sat_tri_sge.sge_integrante_grupo sig\n"
            + "where sig.nit = :nit", nativeQuery = true)
    String collaboratorSupervisor(@Param("nit") String nit);

    //Query para obtener al Especialista de un profecional
    @Query(value = "select sgt.nit_encargado from sat_tri_sge.sge_integrante_grupo sig\n"
            + "inner join sat_tri_sge.sge_grupo_trabjo sgt on sgt.id_grupo = sig.id_grupo \n"
            + "where sig.nit = :nit", nativeQuery = true)
    String collaboratorSpecialist(@Param("nit") String nit);

//    @Query(value = "select sc.nit from sat_tri_sge.sge_colaborador sc\n"
//            + "left join sat_tri_sge.sge_cat_dato scd on sc.id_puesto = scd.codigo\n"
//            + "where sc.tipo_tributa = :tipo and sc.id_puesto = :rol", nativeQuery = true)
//    String collaboratorRol(@Param("tipo") int tipo, @Param("rol") int rol);
    @Query(value = "select sc.nombre, sc.nit from sat_tri_sge.sge_colaborador sc\n"
            + "left join sat_tri_sge.sge_cat_dato scd on sc.tipo_tributa = scd.codigo\n"
            + "where sc.id_puesto = :rol and scd.nombre = :tipo and sc.id_estado = 44", nativeQuery = true)
    List<ColaboradorProjection> collaboratorType(@Param("rol") int rol, @Param("tipo") String tipo);


}
