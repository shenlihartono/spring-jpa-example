package xie.stanley.demoapp.springjpa.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import xie.stanley.demoapp.springjpa.model.World;
import xie.stanley.demoapp.springjpa.repository.WorldRepository;

import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class HelloWorldController {
	private final WorldRepository worldRepository;

	@GetMapping("/world/{id}")
	public String getWorld(@PathVariable Long id) {
		Optional<World> optionalWorld = worldRepository.findById(id);
		return optionalWorld.map(World::getName).orElse("world not found");
	}

	@PostMapping("/world")
	public String createWorld() {
		World newWorld = new World();
		String name = UUID.randomUUID().toString();
		newWorld.setName(name);
		worldRepository.save(newWorld);

		return name;
	}
}
