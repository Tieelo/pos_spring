package de.tieelo.pos_spring.dto;

import de.tieelo.pos_spring.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class CartItemDTO {
	private final Item item;
	private final int amountInCart;
}