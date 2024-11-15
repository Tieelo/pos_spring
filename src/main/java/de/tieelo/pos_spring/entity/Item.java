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
@Table(name = "items")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer items_id;

	@Column(nullable = false, length = 50)
	private String item_name;

	@Column(nullable = false)
	private Float item_price;

	@Column(nullable = false)
	private Float item_stock;

	@ManyToOne
	@JoinColumn(name = "groups_id", nullable = false)
	private Group group;

	public void decreaseStock(int quantity){
		this.item_stock -= quantity;
	}

	public void increaseStock(int quantity){
		this.item_stock += quantity;
	}
}
