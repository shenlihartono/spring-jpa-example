package xie.stanley.demoapp.springjpa.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "world")
@Data
public class World {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
}
