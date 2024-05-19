package com.edu.unbosque.ch0ch4l1t0.controller;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Detalle_reserva;
import com.edu.unbosque.ch0ch4l1t0.model.service.Detalle_reservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/detalles_reserva")
public class Detalle_reservaController {

    @Autowired
    private Detalle_reservaService detalle_reservaService;

    @GetMapping
    public String getAllDetallesReserva(Model model) {
        List<Detalle_reserva> detalles_reserva = detalle_reservaService.findAll();
        model.addAttribute("detalles_reserva", detalles_reserva);
        return "detalles_reserva/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("detalle_reserva", new Detalle_reserva());
        return "detalles_reserva/create";
    }

    @PostMapping("/create")
    public String createDetalle_reserva(@ModelAttribute Detalle_reserva detalle_reserva) {
        detalle_reservaService.save(detalle_reserva);
        return "redirect:/detalles_reserva";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Detalle_reserva detalle_reserva = detalle_reservaService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid detalle reserva Id:" + id));
        model.addAttribute("detalle_reserva", detalle_reserva);
        return "detalles_reserva/edit";
    }

    @PostMapping("/update/{id}")
    public String updateDetalle_reserva(@PathVariable("id") int id, @ModelAttribute Detalle_reserva detalle_reserva) {
        detalle_reservaService.save(detalle_reserva);
        return "redirect:/detalles_reserva";
    }

    @GetMapping("/delete/{id}")
    public String deleteDetalle_reserva(@PathVariable("id") int id) {
        Detalle_reserva detalle_reserva = detalle_reservaService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid detalle reserva Id:" + id));
        detalle_reservaService.deleteById(id);
        return "redirect:/detalles_reserva";
    }
}
