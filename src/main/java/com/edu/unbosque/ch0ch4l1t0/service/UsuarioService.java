package com.edu.unbosque.ch0ch4l1t0.service;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Usuario;
import com.edu.unbosque.ch0ch4l1t0.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(int dni) {
        return usuarioRepository.findById(dni);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteById(int dni) {
        usuarioRepository.deleteById(dni);
    }

    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public List<Usuario> findByRolId(int rolId) {
        return usuarioRepository.findByRolId(rolId);
    }
}
