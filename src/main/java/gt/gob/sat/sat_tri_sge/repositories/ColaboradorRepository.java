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
public interface ColaboradorRepository extends CrudRepository<SgeColaborador, String>{
    
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
}

