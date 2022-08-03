/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.repositories;

import gt.gob.sat.sat_tri_sge.models.SgeColaboradorPerfil;
import gt.gob.sat.sat_tri_sge.models.SgeColaboradorPerfilId;
import gt.gob.sat.sat_tri_sge.projections.PerfilProjection;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author crist
 */
public interface ColaboradorPerfilRepository extends CrudRepository<SgeColaboradorPerfil, SgeColaboradorPerfilId> {

//    @Query(value = "select p.id_Perfil as idPerfil, p.nombre as nombre from sge_Colaborador_Perfil t \n"
//            + " inner join sge_Perfil p on p.id_Perfil = t.id_Perfil \n"
//            + "where t.nit = :pNit and t.estado = 1")
//    List<PerfilProjection> findByNit(@Param("pNit") String pNit);
//
//    List<SgeColaboradorPerfil> findByIdNitAndEstado(String pNit, Integer pEstado);
//
//    Optional<SgeColaboradorPerfil> findByIdAndEstado(SgeColaboradorPerfilId id, Integer pStatus);
//
//    @Override
//    Optional<SgeColaboradorPerfil> findById(SgeColaboradorPerfilId id);

}
