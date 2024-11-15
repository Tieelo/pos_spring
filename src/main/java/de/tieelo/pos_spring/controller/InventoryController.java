package de.tieelo.pos_spring.controller;

import de.tieelo.pos_spring.entity.Group;
import de.tieelo.pos_spring.entity.Item;
import de.tieelo.pos_spring.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

	private final InventoryService inventoryService;

	@Autowired
	public InventoryController(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	@GetMapping("/groups")
	public ResponseEntity<List<Group>> getGroups() {
		List<Group> groups = inventoryService.getGroups();
		return ResponseEntity.ok(groups);
	}

	@GetMapping("/items")
	public ResponseEntity<List<Item>> getItems(@RequestParam(required = false) Integer groupId) {
		List<Item> items = inventoryService.getItems(groupId);
		return ResponseEntity.ok(items);
	}
}
