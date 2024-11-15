package de.tieelo.pos_spring.service;

import de.tieelo.pos_spring.entity.Group;
import de.tieelo.pos_spring.entity.Item;
import de.tieelo.pos_spring.repository.GroupRepository;
import de.tieelo.pos_spring.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private GroupRepository groupRepository;

	public List<Group> getGroups() {
		return groupRepository.findAll();
	}

	public List<Item> getItems(Integer groupId) {
		if (groupId == null) {
			return itemRepository.findAll();
		} else {
			return itemRepository.findByGroupIdOrderByItemName(groupId);
		}
	}

	public Item getItemById(int id) {
		return itemRepository.findById(id).orElse(null);
	}

	public void saveItem(Item item) {
		itemRepository.save(item);
	}
}
