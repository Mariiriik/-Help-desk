package com.example.latartsevaSpring1.service;

import com.example.latartsevaSpring1.dto.TicketCreateDto;
import com.example.latartsevaSpring1.model.Ticket;
import com.example.latartsevaSpring1.model.TicketStatus;
import com.example.latartsevaSpring1.repository.TicketRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket createTicket(TicketCreateDto dto) {
        Ticket ticket = new Ticket();
        ticket.setCustomerName(dto.getCustomerName());
        ticket.setTitle(dto.getTitle());
        ticket.setDescription(dto.getDescription());
        ticket.setStatus(TicketStatus.NEW);
        ticket.setCreatedAt(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAllByOrderByCreatedAtDesc();
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Заявка не найдена: " + id));
    }
}