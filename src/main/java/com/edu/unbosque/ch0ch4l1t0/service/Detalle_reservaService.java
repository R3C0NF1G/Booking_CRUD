package com.edu.unbosque.ch0ch4l1t0.service;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Detalle_reserva;
import com.edu.unbosque.ch0ch4l1t0.repository.Detalle_reservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Detalle_reservaService {

    @Autowired
    private Detalle_reservaRepository detalle_reservaRepository;

    public List<Detalle_reserva> findAll() {
        return detalle_reservaRepository.findAll();
    }

    public Optional<Detalle_reserva> findById(int id) {
        return detalle_reservaRepository.findById(id);
    }

    public Detalle_reserva save(Detalle_reserva detalle_reserva) {
        return detalle_reservaRepository.save(detalle_reserva);
    }

    public void deleteById(int id) {
        detalle_reservaRepository.deleteById(id);
    }
}
