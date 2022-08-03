/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.repositories;

import gt.gob.sat.sat_tri_sge.models.SgePerfil;
import gt.gob.sat.sat_tri_sge.projections.FuncionesProjection;
import gt.gob.sat.sat_tri_sge.projections.PerfilProjection;
import gt.gob.sat.sat_tri_sge.projections.UrlProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author abaestrad
 */
public interface PerfilRepository extends CrudRepository<SgePerfil, Integer> {

    List<PerfilProjection> findByIdRol(Integer pIdRol);

//    @Query(value = "select t.* from sat_tri_sge.sge_opcion_menu t \n"
//            + "inner join sat_tri_sge.sge_perfil_funcion p on p.id_opcion_menu = t.codigo \n"
//            + "inner join sat_tri_sge.sge_colaborador_perfil c on c.id_perfil = p.id_perfil\n"
//            + "where c.nit = :nit and c.estado = 1", nativeQuery = true)
//    List<FuncionesProjection> findByLogin(@Param("nit") String nit);
//
//    @Query(value = "select t.* from sat_tri_sge.sge_url t \n"
//            + "inner join sat_tri_sge.sge_perfil_url p on p.id_url = t.id_url\n"
//            + "inner join sat_tri_sge.sge_colaborador_perfil c on c.id_perfil = p.id_perfil\n"
//            + "where c.nit = :nit and c.estado = 1", nativeQuery = true)
//    List<UrlProjection> findByLoginUrl(@Param("nit") String nit);
//
//    @Query(value = "select t from sge_Perfil t \n"
//            + " inner join sge_Rol p on p.id_Rol = t.id_Rol \n"
//            + "where p.nombre = :pNombre and t.estado = 1")
//    List<PerfilProjection> findByRolName(@Param("pNombre") String pNombre);

}
