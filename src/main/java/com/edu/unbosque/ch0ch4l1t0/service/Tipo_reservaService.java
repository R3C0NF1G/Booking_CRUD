package com.edu.unbosque.ch0ch4l1t0.service;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Tipo_reserva;
import com.edu.unbosque.ch0ch4l1t0.repository.Tipo_reservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Tipo_reservaService {

    @Autowired
    private Tipo_reservaRepository tipo_reservaRepository;

    public List<Tipo_reserva> findAll() {
        return tipo_reservaRepository.findAll();
    }

    public Optional<Tipo_reserva> findById(int id) {
        return tipo_reservaRepository.findById(id);
    }

    public Tipo_reserva save(Tipo_reserva tipo_reserva) {
        return tipo_reservaRepository.save(tipo_reserva);
    }

    public void deleteById(int id) {
        tipo_reservaRepository.deleteById(id);
    }
}
