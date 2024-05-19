package com.edu.unbosque.ch0ch4l1t0.controller;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Usuario;
import com.edu.unbosque.ch0ch4l1t0.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String getAllUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuarios/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/create";
    }

    @PostMapping("/create")
    public String createUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/edit/{dni}")
    public String showEditForm(@PathVariable("dni") int dni, Model model) {
        Usuario usuario = usuarioService.findById(dni).orElseThrow(() -> new IllegalArgumentException("Invalid usuario DNI:" + dni));
        model.addAttribute("usuario", usuario);
        return "usuarios/edit";
    }

    @PostMapping("/update/{dni}")
    public String updateUsuario(@PathVariable("dni") int dni, @ModelAttribute Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/delete/{dni}")
    public String deleteUsuario(@PathVariable("dni") int dni) {
        Usuario usuario = usuarioService.findById(dni).orElseThrow(() -> new IllegalArgumentException("Invalid usuario DNI:" + dni));
        usuarioService.deleteById(dni);
        return "redirect:/usuarios";
    }
}
