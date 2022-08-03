/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.repositories;

import gt.gob.sat.sat_tri_sge.models.SgeUnidadAdministrativa;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author alexa
 */
public interface UnidadAdministrativaRepository extends CrudRepository<SgeUnidadAdministrativa, Long>{
    
    List<SgeUnidadAdministrativa> findByIdUnidadProsisIsNotNull();
    
    SgeUnidadAdministrativa findByIdUnidadProsis(Integer id);
    
}
