package de.tieelo.pos_spring.entity;

import lombok.Data;
import jakarta.persistence.*;

import java.util.Set;

@Data
@Entity
@Table(name = "groups")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(nullable = false)
	private Float salevolume;

	@Column(nullable = false, length = 50)
	private String measurement;

	@Column(nullable = false)
	private Float tax;

	@OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Item> items;
}
