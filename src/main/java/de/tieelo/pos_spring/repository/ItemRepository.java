package de.tieelo.pos_spring.repository;

import de.tieelo.pos_spring.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	List<Item> findAllByGroupId(int groupId);
	List<Item> findByGroupIdOrderByNameAsc(int groupId);
}

