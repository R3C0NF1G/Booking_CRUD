package com.edu.unbosque.ch0ch4l1t0.model.repository;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    @Query("SELECT r FROM reserva r WHERE r.usuario.dni = :dni_usuario")
    List<Reserva> findByUsuarioDni(@Param("dni_usuario") int dni_usuario);

}
