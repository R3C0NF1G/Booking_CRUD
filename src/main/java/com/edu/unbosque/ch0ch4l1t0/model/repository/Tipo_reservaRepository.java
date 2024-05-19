package com.edu.unbosque.ch0ch4l1t0.model.repository;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Tipo_reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tipo_reservaRepository extends JpaRepository<Tipo_reserva, Integer> {
}
