package com.example.latartsevaSpring1.repository;

import com.example.latartsevaSpring1.model.Ticket;
import com.example.latartsevaSpring1.model.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByOrderByCreatedAtDesc();
    List<Ticket> findByStatus(TicketStatus status);
    List<Ticket> findByCustomerNameContainingIgnoreCase(String customerName);
}