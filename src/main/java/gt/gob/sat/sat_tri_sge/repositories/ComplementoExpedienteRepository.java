/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.repositories;

import gt.gob.sat.sat_tri_sge.models.SgeComplementoExpediente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author crist
 */
public interface ComplementoExpedienteRepository extends CrudRepository<SgeComplementoExpediente, String>{
    
}
