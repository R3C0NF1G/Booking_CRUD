package com.edu.unbosque.ch0ch4l1t0.controller;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Tipo_reserva;
import com.edu.unbosque.ch0ch4l1t0.repository.Tipo_reservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tipos_reserva")
public class Tipo_reservaController {

    @Autowired
    private Tipo_reservaRepository tipoReservaRepository;

    @GetMapping
    public String getAllTiposReserva(Model model) {
        List<Tipo_reserva> tiposReserva = tipoReservaRepository.findAll();
        model.addAttribute("tiposReserva", tiposReserva);
        return "tipos_reserva/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("tipoReserva", new Tipo_reserva());
        return "tipos_reserva/create";
    }

    @PostMapping("/create")
    public String createTipoReserva(@ModelAttribute Tipo_reserva tipoReserva) {
        tipoReservaRepository.save(tipoReserva);
        return "redirect:/tipos_reserva";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Tipo_reserva tipoReserva = tipoReservaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid tipo reserva Id:" + id));
        model.addAttribute("tipoReserva", tipoReserva);
        return "tipos_reserva/edit";
    }

    @PostMapping("/update/{id}")
    public String updateTipoReserva(@PathVariable("id") int id, @ModelAttribute Tipo_reserva tipoReserva) {
        tipoReservaRepository.save(tipoReserva);
        return "redirect:/tipos_reserva";
    }

    @GetMapping("/delete/{id}")
    public String deleteTipoReserva(@PathVariable("id") int id) {
        Tipo_reserva tipoReserva = tipoReservaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid tipo reserva Id:" + id));
        tipoReservaRepository.delete(tipoReserva);
        return "redirect:/tipos_reserva";
    }
}
