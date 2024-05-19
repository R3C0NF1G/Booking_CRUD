package com.edu.unbosque.ch0ch4l1t0.controller;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Detalle_reserva;
import com.edu.unbosque.ch0ch4l1t0.repository.Detalle_reservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/detalles_reserva")
public class Detalle_reservaController {

    @Autowired
    private Detalle_reservaRepository detalleReservaRepository;

    @GetMapping
    public String getAllDetallesReserva(Model model) {
        List<Detalle_reserva> detallesReserva = detalleReservaRepository.findAll();
        model.addAttribute("detallesReserva", detallesReserva);
        return "detalles_reserva/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("detalleReserva", new Detalle_reserva());
        return "detalles_reserva/create";
    }

    @PostMapping("/create")
    public String createDetalleReserva(@ModelAttribute Detalle_reserva detalleReserva) {
        detalleReservaRepository.save(detalleReserva);
        return "redirect:/detalles_reserva";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Detalle_reserva detalleReserva = detalleReservaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid detalle reserva Id:" + id));
        model.addAttribute("detalleReserva", detalleReserva);
        return "detalles_reserva/edit";
    }

    @PostMapping("/update/{id}")
    public String updateDetalleReserva(@PathVariable("id") int id, @ModelAttribute Detalle_reserva detalleReserva) {
        detalleReservaRepository.save(detalleReserva);
        return "redirect:/detalles_reserva";
    }

    @GetMapping("/delete/{id}")
    public String deleteDetalleReserva(@PathVariable("id") int id) {
        Detalle_reserva detalleReserva = detalleReservaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid detalle reserva Id:" + id));
        detalleReservaRepository.delete(detalleReserva);
        return "redirect:/detalles_reserva";
    }
}

