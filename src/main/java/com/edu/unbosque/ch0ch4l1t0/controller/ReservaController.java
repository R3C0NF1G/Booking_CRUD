package com.edu.unbosque.ch0ch4l1t0.controller;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Reserva;
import com.edu.unbosque.ch0ch4l1t0.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public String getAllReservas(Model model) {
        List<Reserva> reservas = reservaService.findAll();
        model.addAttribute("reservas", reservas);
        return "reservas/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "reservas/create";
    }

    @PostMapping("/create")
    public String createReserva(@ModelAttribute Reserva reserva) {
        reservaService.save(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Reserva reserva = reservaService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid reserva Id:" + id));
        model.addAttribute("reserva", reserva);
        return "reservas/edit";
    }

    @PostMapping("/update/{id}")
    public String updateReserva(@PathVariable("id") int id, @ModelAttribute Reserva reserva) {
        reservaService.save(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/delete/{id}")
    public String deleteReserva(@PathVariable("id") int id) {
        Reserva reserva = reservaService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid reserva Id:" + id));
        reservaService.deleteById(id);
        return "redirect:/reservas";
    }
}
