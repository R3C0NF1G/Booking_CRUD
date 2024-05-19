package com.edu.unbosque.ch0ch4l1t0.controller;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Rol;
import com.edu.unbosque.ch0ch4l1t0.model.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public String getAllRoles(Model model) {
        List<Rol> roles = rolService.findAll();
        model.addAttribute("roles", roles);
        return "roles/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("rol", new Rol());
        return "roles/create";
    }

    @PostMapping("/create")
    public String createRol(@ModelAttribute Rol rol) {
        rolService.save(rol);
        return "redirect:/roles";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Rol rol = rolService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid rol Id:" + id));
        model.addAttribute("rol", rol);
        return "roles/edit";
    }

    @PostMapping("/update/{id}")
    public String updateRol(@PathVariable("id") int id, @ModelAttribute Rol rol) {
        rolService.save(rol);
        return "redirect:/roles";
    }

    @GetMapping("/delete/{id}")
    public String deleteRol(@PathVariable("id") int id) {
        Rol rol = rolService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid rol Id:" + id));
        rolService.deleteById(id);
        return "redirect:/roles";
    }
}
