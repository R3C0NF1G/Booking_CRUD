package com.edu.unbosque.ch0ch4l1t0.repository;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
}