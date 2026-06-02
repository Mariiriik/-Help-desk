package com.example.latartsevaSpring1.service;

import com.example.latartsevaSpring1.dto.TicketCreateDto;
import com.example.latartsevaSpring1.model.Ticket;
import java.util.List;

public interface TicketService {
    Ticket createTicket(TicketCreateDto dto);
    List<Ticket> getAllTickets();
    Ticket getTicketById(Long id);
}