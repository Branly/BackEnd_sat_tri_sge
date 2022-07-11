/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.repositories;

import gt.gob.sat.sat_tri_sge.models.SgeAgenda;
import gt.gob.sat.sat_tri_sge.projections.AgendaProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author crist
 */
public interface AgendaRepository extends CrudRepository<SgeAgenda, String> {

    @Query(value = "select sa.id_agenda, sa.asunto_agenda, date(sa.fecha_creacion) as Fecha_creacion \n"
            + "from sat_tri_sge.sge_agenda sa", nativeQuery = true)
    List<AgendaProjection> diaryList();

}
