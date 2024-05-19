package com.edu.unbosque.ch0ch4l1t0.controller;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Sede;
import com.edu.unbosque.ch0ch4l1t0.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sedes")
public class SedeController {

    @Autowired
    private SedeService sedeService;

    @GetMapping
    public String getAllSedes(Model model) {
        List<Sede> sedes = sedeService.findAll();
        model.addAttribute("sedes", sedes);
        return "sedes/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("sede", new Sede());
        return "sedes/create";
    }

    @PostMapping("/create")
    public String createSede(@ModelAttribute Sede sede) {
        sedeService.save(sede);
        return "redirect:/sedes";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Sede sede = sedeService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid sede Id:" + id));
        model.addAttribute("sede", sede);
        return "sedes/edit";
    }

    @PostMapping("/update/{id}")
    public String updateSede(@PathVariable("id") int id, @ModelAttribute Sede sede) {
        sedeService.save(sede);
        return "redirect:/sedes";
    }

    @GetMapping("/delete/{id}")
    public String deleteSede(@PathVariable("id") int id) {
        Sede sede = sedeService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid sede Id:" + id));
        sedeService.deleteById(id);
        return "redirect:/sedes";
    }
}
