package de.tieelo.pos_spring.service;

import de.tieelo.pos_spring.dto.CartItemDTO;
import de.tieelo.pos_spring.entity.Item;
import de.tieelo.pos_spring.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {

	@Autowired
	private InventoryService inventoryService;

	@Autowired
	private ItemRepository itemRepository;

//	@Autowired
//	private InvoiceService invoiceService;

	private Map<Item, Integer> itemsInCart = new HashMap<>();

	public void addItemToCart(int[] idAndAmount) {
		Item item = inventoryService.getItemById(idAndAmount[0]);
		if (item != null) {
			item.decreaseStock(idAndAmount[1]);
			itemsInCart.put(item, itemsInCart.getOrDefault(item, 0) + idAndAmount[1]);
			inventoryService.saveItem(item);
		}
	}

	public void removeItemFromCart(int[] idAndAmount) {
		Item item = inventoryService.getItemById(idAndAmount[0]);
		if (item != null) {
			Integer currentAmount = itemsInCart.get(item);
			if (currentAmount != null) {
				if (idAndAmount[1] < currentAmount) {
					itemsInCart.put(item, currentAmount - idAndAmount[1]);
					item.increaseStock(idAndAmount[1]);
				} else {
					itemsInCart.remove(item);
				}
				inventoryService.saveItem(item);
			}
		}
	}

	public double getTotalCost() {
		return itemsInCart.entrySet().stream()
				.mapToDouble(entry -> entry.getKey().getItem_price() * entry.getValue())
				.sum();
	}

	public int getItemCount() {
		return itemsInCart.values().stream()
				.mapToInt(Integer::intValue)
				.sum();
	}

	public void checkout() {
		itemsInCart.clear();
//		invoiceService.createInvoice(); // Implementieren Sie logische Erstellungen und DB Schreibaktion
	}

	public Map<Item, Integer> getItemsInCart() {
		return new HashMap<>(itemsInCart);
	}

	public List<CartItemDTO> getItemsFromCart() {
		List<CartItemDTO> cartItems = new ArrayList<>();

		for (Map.Entry<Item, Integer> entry : itemsInCart.entrySet()) {
			CartItemDTO cartItem = new CartItemDTO(entry.getKey(), entry.getValue());
			cartItems.add(cartItem);
		}
		return cartItems;
	}

	public void putCartBackToInventory() {
		itemsInCart.forEach((item, quantity) -> {
			item.increaseStock(quantity);
			itemRepository.save(item);
		});
		itemsInCart.clear();
	}
}