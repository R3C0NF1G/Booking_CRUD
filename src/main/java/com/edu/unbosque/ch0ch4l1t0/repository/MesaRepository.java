package com.edu.unbosque.ch0ch4l1t0.repository;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Integer> {

    @Query("SELECT m FROM mesa m WHERE m.estado = true")
    List<Mesa> findMesasDisponibles();

}
