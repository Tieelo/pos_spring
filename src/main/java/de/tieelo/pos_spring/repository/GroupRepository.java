package de.tieelo.pos_spring.repository;

import de.tieelo.pos_spring.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {
}
