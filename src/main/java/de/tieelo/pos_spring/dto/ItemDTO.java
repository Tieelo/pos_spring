package de.tieelo.pos_spring.dto;

import com.google.gson.Gson;
import de.tieelo.pos_spring.entity.Item;
import lombok.Data;

@Data
public class ItemDTO implements Comparable<ItemDTO> {
	private Integer id;
	private String group;
	private String name;
	private float price;
	private float stock;
	private String measurement;

//	// Konstruktor, der eine Item-Entität akzeptiert
//	public ItemDTO(Item item) {
//		this.id = item.getItems_id();
//		this.group = item.getGroup().getGroup_names(); // Beispielsweise, wenn `group` auch String hat
//		this.name = item.getItem_name();
//		this.price = item.getItem_price();
//		this.stock = item.getItem_stock();
//		// measurement Feld aus Entität annehmen
//	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	public String[] toStringArray() {
		return new String[]{String.valueOf(id), group, name, String.valueOf(price), String.valueOf(stock), measurement};
	}

	@Override
	public int compareTo(ItemDTO other) {
		return Double.compare(this.price, other.price);
	}

	// Optional, falls gebraucht
	public Integer getGroupId() {
		return id; // Oder jeder Logic die manchmal benötigt wird
	}
}