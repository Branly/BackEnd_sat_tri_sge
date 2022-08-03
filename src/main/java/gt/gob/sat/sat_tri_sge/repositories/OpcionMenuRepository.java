/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.repositories;

import gt.gob.sat.sat_tri_sge.models.SgeOpcionesMenu;
import gt.gob.sat.sat_tri_sge.projections.OpcionMenuProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author abaestrad
 */
public interface OpcionMenuRepository extends CrudRepository<SgeOpcionesMenu, String> {

    @Query(value = "select om.codigo as id, om.titulo as title, om.icono as icon, cast((\n"
            + "	select array_to_json(array_agg(row_to_json(so))) from (\n"
            + "     select\n"
            + "         so.codigo id, so.titulo title, so.icono icon, so.ruta route\n"
            + "     from\n"
            + "         sat_tri_sge.sge_opcion_menu so\n"
            + "     where\n"
            + "         om.codigo = so.codigo_padre and so.codigo in (:functions)\n"
            + "     order by so.codigo\n"
            + "	 ) so\n"
            + " ) as varchar) as children\n"
            + " from\n"
            + "     sat_tri_sge.sge_opcion_menu om\n"
            + "     \n"
            + " where\n"
            + "     om.codigo_padre is null",
            nativeQuery = true
    )
    List<OpcionMenuProjection> getAllowMenuOption(@Param("functions") List<String> functions);

    @Query(value = "select om.codigo as id, om.titulo as title, om.icono as icon, cast((\n"
            + "	select array_to_json(array_agg(row_to_json(so))) from (\n"
            + "     select\n"
            + "         so.codigo id, so.titulo title, so.icono icon, so.ruta route\n"
            + "     from\n"
            + "         sat_tri_sge.sge_opcion_menu so\n"
            + "     where\n"
            + "         om.codigo = so.codigo_padre\n"
            + "     order by so.codigo\n"
            + "	 ) so\n"
            + " ) as varchar) as children\n"
            + " from\n"
            + "     sat_tri_sge.sge_opcion_menu om\n"
            + " where\n"
            + "     om.codigo_padre is null     ",
            nativeQuery = true
    )
    List<OpcionMenuProjection> getAllowMenuOption();

}
