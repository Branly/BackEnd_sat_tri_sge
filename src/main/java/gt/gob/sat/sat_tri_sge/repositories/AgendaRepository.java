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
import org.springframework.data.repository.query.Param;

/**
 *
 * @author crist
 */
public interface AgendaRepository extends CrudRepository<SgeAgenda, String> {

    //Query para el secretario
    @Query(value = "select sa.id_agenda, sa.asunto_agenda, date(sa.fecha_creacion) as Fecha_creacion\n"
            + "from sat_tri_sge.sge_agenda sa\n"
            + "where sa.tipo_agenda = :tipo", nativeQuery = true)
    List<AgendaProjection> diaryList(@Param("tipo") int tipo);

    //Query para el Especialista
    @Query(value = "select sa.id_agenda, sa.asunto_agenda, date(sa.fecha_creacion) as fecha_creacion from sat_tri_sge.sge_agenda sa\n"
            + "inner join sat_tri_sge.sge_expediente se on sa.id_agenda = se.id_agenda\n"
            + "inner join sat_tri_sge.sge_integrante_grupo sig on se.nit_profesional = sig.nit\n"
            + "inner join sat_tri_sge.sge_grupo_trabjo sgt on sgt.id_grupo = sig.id_grupo\n"
            + "where sgt.nit_encargado = :nit", nativeQuery = true)
    List<AgendaProjection> specialistList(@Param("nit") String nit);

}
