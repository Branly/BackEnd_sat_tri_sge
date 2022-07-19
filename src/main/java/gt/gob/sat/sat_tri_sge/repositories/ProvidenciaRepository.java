/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.repositories;

import gt.gob.sat.sat_tri_sge.models.SgeProvidencia;
import gt.gob.sat.sat_tri_sge.projections.ProvidenciaProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author crist
 */
public interface ProvidenciaRepository extends CrudRepository<SgeProvidencia, String> {

    @Query(value = "select distinct substring(sp.id_providencia, 17, 6) as Id, sp.fecha_creacion \n"
            + "from sat_tri_sge.sge_providencia sp\n"
            + "inner join sat_tri_sge.sge_expediente_providencia sep on sep.id_providencia = sp.id_providencia\n"
            + "inner join sat_tri_sge.sge_expediente se on se.no_expediente_tributa = sep.no_expediente_tributa\n"
            + "where se.tipo_recurso = :tribunal and sp.tipo_providencia = :tipo\n"
            + "order by sp.fecha_creacion desc\n"
            + "limit 1", nativeQuery = true)
    public ProvidenciaProjection idProvidens(@Param("tribunal") int tribunal, @Param("tipo") int tipo);
}
