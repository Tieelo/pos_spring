package de.tieelo.pos_spring.entity;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "groups")
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer groups_id;

	@Column(nullable = false, length = 50)
	private String group_names;

	@Column(nullable = false)
	private Float salevolume;

	@Column(nullable = false, length = 50)
	private String measurement;

	@Column(nullable = false)
	private Float tax;
}
