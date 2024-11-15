package de.tieelo.pos_spring.repository;

import de.tieelo.pos_spring.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
