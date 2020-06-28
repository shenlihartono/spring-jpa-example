package xie.stanley.demoapp.springmysql.repository;

import org.springframework.data.repository.CrudRepository;
import xie.stanley.demoapp.springmysql.model.World;

public interface WorldRepository extends CrudRepository<World, Long> {
}
