package de.tieelo.pos_spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "items", schema = "pos_tables")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(nullable = false)
	private Float price;

	@Column(nullable = false)
	private Float stock;

	@ManyToOne
	@JoinColumn(name = "group_id", nullable = false)
	private Group group;

	public void decreaseStock(int quantity){
		this.stock -= quantity;
	}

	public void increaseStock(int quantity){
		this.stock += quantity;
	}
}
