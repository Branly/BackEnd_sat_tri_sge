/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.repositories;

import gt.gob.sat.sat_tri_sge.models.SgeIntegranteGrupo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author crist
 */
public interface IntegranteGrupoRepository extends CrudRepository<SgeIntegranteGrupo, Object> {

    @Query(value = "select sig.nit from sat_tri_sge.sge_integrante_grupo sig\n"
            + "where sig.id_grupo = :grupo and sig.nit_supervisor = :nit", nativeQuery = true)
    List<String> deleteSupervisor(@Param("nit") String nit, @Param("grupo") int grupo);

}
