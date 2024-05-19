package com.edu.unbosque.ch0ch4l1t0.service;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Sede;
import com.edu.unbosque.ch0ch4l1t0.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SedeService {

    @Autowired
    private SedeRepository sedeRepository;

    public List<Sede> findAll() {
        return sedeRepository.findAll();
    }

    public Optional<Sede> findById(int id) {
        return sedeRepository.findById(id);
    }

    public Sede save(Sede sede) {
        return sedeRepository.save(sede);
    }

    public void deleteById(int id) {
        sedeRepository.deleteById(id);
    }

    public List<Sede> findByCiudad(String ciudad) {
        return sedeRepository.findByCiudad(ciudad);
    }
}

