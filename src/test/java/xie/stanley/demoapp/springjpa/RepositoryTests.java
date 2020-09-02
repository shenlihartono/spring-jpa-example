package xie.stanley.demoapp.springjpa;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import xie.stanley.demoapp.springjpa.model.World;
import xie.stanley.demoapp.springjpa.repository.WorldRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class RepositoryTests {
    private static final Logger logger = LoggerFactory.getLogger(RepositoryTests.class);

    @Autowired
    private WorldRepository worldRepository;

    @Test
    void injectedComponentsAreNotNull() {
        assertThat(worldRepository).isNotNull();
    }

    @Test
    void should_ReturnTwoResults_When_FindAll() {
        logger.info("start");

        World world1 = new World();
        world1.setName("dunia");
        worldRepository.save(world1);

        World world2 = new World();
        world2.setName("dunia baru");
        worldRepository.save(world2);

        logger.info("after insert 2 rows");

        int expectedSize = 2;

        logger.info("before call find all");
        Iterable<World> worlds = worldRepository.findAll();
        assertThat(worlds).hasSize(expectedSize);
    }

    @Test
    void should_ReturnUpdatedResult_When_UpdateModel() {
        // save
        World world1 = new World();
        world1.setName("dunia maya");
        worldRepository.save(world1);

        // find
        Long theId = world1.getId();
        assertThat(theId).isNotNull();
        Optional<World> worldOptional = worldRepository.findById(theId);
        assertThat(worldOptional.isPresent()).isTrue();

        World myWorld = worldOptional.get();
        assertThat(myWorld.getName()).isEqualTo("dunia maya");

        // update
        myWorld.setName("dunia baru");
        worldRepository.save(world1);

        // find
        worldOptional = worldRepository.findById(theId);
        assertThat(worldOptional.isPresent()).isTrue();
        myWorld = worldOptional.get();
        assertThat(myWorld.getName()).isEqualTo("dunia baru");
    }
}
