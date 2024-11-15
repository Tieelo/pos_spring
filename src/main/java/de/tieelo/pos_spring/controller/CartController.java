package de.tieelo.pos_spring.controller;

import de.tieelo.pos_spring.dto.CartItemDTO;
import de.tieelo.pos_spring.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

	private final CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@PostMapping("/fill")
	public ResponseEntity<Void> fillCart(@RequestBody int[] idAndAmount) {
		cartService.addItemToCart(idAndAmount);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/sell")
	public ResponseEntity<Void> sellCart() {
		cartService.checkout();
		return ResponseEntity.ok().build();
	}

	@GetMapping("/total")
	public ResponseEntity<Double> getTotalCost() {
		double total = cartService.getTotalCost();
		return ResponseEntity.ok(total);
	}

	@PostMapping("/items/remove")
	public ResponseEntity<Void> removeItemById(@RequestBody int[] idAndAmount) {
		cartService.removeItemFromCart(idAndAmount);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/return")
	public ResponseEntity<Void> putCartBackToInventory() {
		cartService.putCartBackToInventory();
		return ResponseEntity.ok().build();
	}

	@GetMapping("/count")
	public ResponseEntity<Integer> getItemCount() {
		int count = cartService.getItemCount();
		return ResponseEntity.ok(count);
	}

	@GetMapping("/items")
	public ResponseEntity<List<CartItemDTO>> getItemsInCart() {
		List<CartItemDTO> items = cartService.getItemsFromCart();
		return ResponseEntity.ok(items);
	}
}