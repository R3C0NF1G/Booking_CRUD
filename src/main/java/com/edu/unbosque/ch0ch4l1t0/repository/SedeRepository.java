package com.edu.unbosque.ch0ch4l1t0.repository;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SedeRepository extends JpaRepository<Sede, Integer> {

    @Query("SELECT s FROM Sede s WHERE s.ciudad = :ciudad")
    List<Sede> findByCiudad(@Param("ciudad") String ciudad);

}
