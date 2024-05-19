package com.edu.unbosque.ch0ch4l1t0.controller;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Tipo_reserva;
import com.edu.unbosque.ch0ch4l1t0.model.service.Tipo_reservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tipos_reserva")
public class Tipo_reservaController {

    @Autowired
    private Tipo_reservaService tipo_reservaService;

    @GetMapping
    public String getAllTipos_reserva(Model model) {
        List<Tipo_reserva> tipos_reserva = tipo_reservaService.findAll();
        model.addAttribute("tipos_reserva", tipos_reserva);
        return "tipos_reserva/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("tipo_reserva", new Tipo_reserva());
        return "tipos_reserva/create";
    }

    @PostMapping("/create")
    public String createTipo_reserva(@ModelAttribute Tipo_reserva tipo_reserva) {
        tipo_reservaService.save(tipo_reserva);
        return "redirect:/tipos_reserva";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Tipo_reserva tipo_reserva = tipo_reservaService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid tipo reserva Id:" + id));
        model.addAttribute("tipo_reserva", tipo_reserva);
        return "tipos_reserva/edit";
    }

    @PostMapping("/update/{id}")
    public String updateTipo_reserva(@PathVariable("id") int id, @ModelAttribute Tipo_reserva tipo_reserva) {
        tipo_reservaService.save(tipo_reserva);
        return "redirect:/tipos_reserva";
    }

    @GetMapping("/delete/{id}")
    public String deleteTipo_reserva(@PathVariable("id") int id) {
        Tipo_reserva tipoReserva = tipo_reservaService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid tipo reserva Id:" + id));
        tipo_reservaService.deleteById(id);
        return "redirect:/tipos_reserva";
    }
}
