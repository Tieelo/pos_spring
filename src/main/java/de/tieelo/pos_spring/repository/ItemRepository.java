package de.tieelo.pos_spring.repository;

import de.tieelo.pos_spring.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	List<Item> findAllByGroup_Groups_id(int groupId);
	List<Item> findByGroupIdOrderByItemName(int groupId);
}
