package com.edu.unbosque.ch0ch4l1t0.controller;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Auditoria;
import com.edu.unbosque.ch0ch4l1t0.repository.AuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/auditorias")
public class AuditoriaController {

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @GetMapping
    public String getAllAuditorias(Model model) {
        List<Auditoria> auditorias = auditoriaRepository.findAll();
        model.addAttribute("auditorias", auditorias);
        return "auditorias/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("auditoria", new Auditoria());
        return "auditorias/create";
    }

    @PostMapping("/create")
    public String createAuditoria(@ModelAttribute Auditoria auditoria) {
        auditoriaRepository.save(auditoria);
        return "redirect:/auditorias";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Auditoria auditoria = auditoriaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid auditoria Id:" + id));
        model.addAttribute("auditoria", auditoria);
        return "auditorias/edit";
    }

    @PostMapping("/update/{id}")
    public String updateAuditoria(@PathVariable("id") int id, @ModelAttribute Auditoria auditoria) {
        auditoriaRepository.save(auditoria);
        return "redirect:/auditorias";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuditoria(@PathVariable("id") int id) {
        Auditoria auditoria = auditoriaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid auditoria Id:" + id));
        auditoriaRepository.delete(auditoria);
        return "redirect:/auditorias";
    }
}
