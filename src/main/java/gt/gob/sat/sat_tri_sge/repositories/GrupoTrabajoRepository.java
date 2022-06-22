/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.repositories;

import gt.gob.sat.sat_tri_sge.models.SgeGrupoTrabjo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import gt.gob.sat.sat_tri_sge.projections.GrupoTrabajoProjection;

/**
 *
 * @author crist
 */
public interface GrupoTrabajoRepository extends CrudRepository<SgeGrupoTrabjo, Integer> {

    //Query para traer a todos los grupos kkk
    @Query(value = "select sg.id_grupo, \n"
            + "sg.nombre from sat_tri_sge.sge_grupo_trabjo sg", nativeQuery = true)
    List<GrupoTrabajoProjection> Grupos();
}
