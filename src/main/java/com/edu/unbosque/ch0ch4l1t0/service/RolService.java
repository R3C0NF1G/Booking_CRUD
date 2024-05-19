package com.edu.unbosque.ch0ch4l1t0.service;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Rol;
import com.edu.unbosque.ch0ch4l1t0.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    public Optional<Rol> findById(int id) {
        return rolRepository.findById(id);
    }

    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    public void deleteById(int id) {
        rolRepository.deleteById(id);
    }
}

