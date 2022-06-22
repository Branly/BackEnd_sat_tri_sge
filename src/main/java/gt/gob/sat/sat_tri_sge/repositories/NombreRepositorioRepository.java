package gt.gob.sat.sat_tri_sge.repositories;

import org.springframework.data.repository.CrudRepository;

import gt.gob.sat.arquitectura.microservices.config.models.AbstractEntity;

public interface NombreRepositorioRepository extends CrudRepository<AbstractEntity, Integer> {

}
