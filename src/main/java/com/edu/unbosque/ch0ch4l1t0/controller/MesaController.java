package com.edu.unbosque.ch0ch4l1t0.controller;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Mesa;
import com.edu.unbosque.ch0ch4l1t0.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mesas")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @GetMapping
    public String getAllMesas(Model model) {
        List<Mesa> mesas = mesaService.findAll();
        model.addAttribute("mesas", mesas);
        return "mesas/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("mesa", new Mesa());
        return "mesas/create";
    }

    @PostMapping("/create")
    public String createMesa(@ModelAttribute Mesa mesa) {
        mesaService.save(mesa);
        return "redirect:/mesas";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Mesa mesa = mesaService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid mesa Id:" + id));
        model.addAttribute("mesa", mesa);
        return "mesas/edit";
    }

    @PostMapping("/update/{id}")
    public String updateMesa(@PathVariable("id") int id, @ModelAttribute Mesa mesa) {
        mesaService.save(mesa);
        return "redirect:/mesas";
    }

    @GetMapping("/delete/{id}")
    public String deleteMesa(@PathVariable("id") int id) {
        Mesa mesa = mesaService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid mesa Id:" + id));
        mesaService.deleteById(id);
        return "redirect:/mesas";
    }
}

