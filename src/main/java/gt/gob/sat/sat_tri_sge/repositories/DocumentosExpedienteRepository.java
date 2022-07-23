/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.repositories;

import gt.gob.sat.sat_tri_sge.models.SgeExpediente;
import gt.gob.sat.sat_tri_sge.projections.DocumentosExpedienteProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author alexa
 */
public interface DocumentosExpedienteRepository extends CrudRepository<SgeExpediente, String>{
    
    @Query(value="select se.no_expediente \"expediente\"\n" 
            + "from sat_tri_sge.sge_expediente se \n"
            +"where se.no_expediente = :no_expediente \n",
            nativeQuery = true)
    public List<DocumentosExpedienteProjection> getNoExpediente(@Param("no_expediente") String no_expediente);
    
}
