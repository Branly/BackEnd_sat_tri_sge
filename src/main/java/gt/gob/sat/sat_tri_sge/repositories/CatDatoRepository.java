/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.repositories;

import gt.gob.sat.sat_tri_sge.models.SgeCatDato;
import gt.gob.sat.sat_tri_sge.projections.DatosProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author crist
 */
public interface CatDatoRepository extends CrudRepository<SgeCatDato, Integer> {

    // Query quer debuelve los tipos de Dato
    @Query(value = "select scd.nombre, scd.codigo from sat_tri_sge.sge_cat_dato scd\n"
            + "where scd.codigo_catalogo = :tipo", nativeQuery = true)
    List<DatosProjection> data(@Param("tipo") int tipo);

    @Query(value = "select scd.nombre, scd.codigo from sat_tri_sge.sge_cat_dato scd\n"
            + "where scd.codigo_dato_padre  = :tipo", nativeQuery = true)
    List<DatosProjection> subData(@Param("tipo") int tipo);

    // Query quer debuelve los tipos de Dato
    @Query(value = "select scd.descripcion as nombre, scd.codigo from sat_tri_sge.sge_cat_dato scd\n"
            + "where scd.codigo_catalogo = 11", nativeQuery = true)
    List<DatosProjection> getObservation();

}
