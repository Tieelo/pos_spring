package de.tieelo.pos_spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "invoice")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer invoice_id;

	@Column(nullable = false, length = 50)
	private String item_name;

	@Column(nullable = false)
	private Float amount;

	@Column(nullable = false)
	private Float total_price;

	@Column(nullable = false)
	private Float bill_cost;

	@Column(nullable = false, length = 50)
	private String bill_number;

	@Column(nullable = false, length = 50)
	private String date;

	@Column(nullable = false)
	private Boolean storno;
}
