package com.example.latartsevaSpring1.controller;

import com.example.latartsevaSpring1.repository.TicketRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TicketController {

    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/tickets")
    public String tickets(Model model) {
        model.addAttribute("tickets", ticketRepository.findAllByOrderByCreatedAtDesc());
        return "tickets";
    }
    @GetMapping("/tickets/customer")
    public String ticketsByCustomer(@RequestParam(required = false) String name, Model model) {
        if (name != null && !name.trim().isEmpty()) {
            model.addAttribute("tickets", ticketRepository.findByCustomerNameContainingIgnoreCase(name));
        } else {
            model.addAttribute("tickets", ticketRepository.findAllByOrderByCreatedAtDesc());
        }
        return "tickets"; // используем тот же шаблон
    }
}