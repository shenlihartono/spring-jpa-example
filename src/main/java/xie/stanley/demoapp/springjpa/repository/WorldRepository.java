package xie.stanley.demoapp.springjpa.repository;

import org.springframework.data.repository.CrudRepository;
import xie.stanley.demoapp.springjpa.model.World;

public interface WorldRepository extends CrudRepository<World, Long> {
}
