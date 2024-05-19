package com.edu.unbosque.ch0ch4l1t0.model.service;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Mesa;
import com.edu.unbosque.ch0ch4l1t0.model.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    public List<Mesa> findAll() {
        return mesaRepository.findAll();
    }

    public Optional<Mesa> findById(int id) {
        return mesaRepository.findById(id);
    }

    public Mesa save(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    public void deleteById(int id) {
        mesaRepository.deleteById(id);
    }

    public List<Mesa> findMesasDisponibles() {
        return mesaRepository.findMesasDisponibles();
    }
}

