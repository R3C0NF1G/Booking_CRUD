package com.edu.unbosque.ch0ch4l1t0.repository;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;

@Repository
public interface AuditoriaRepository extends JpaRepository<Auditoria, Integer> {

    @Modifying
    @Query(value = "INSERT INTO auditoria (accion, tabla_afectada, detalle_accion, fecha, dni_usuario) VALUES (:accion, :tabla_afectada, :detalle_accion, :fecha, :dni_usuario)", nativeQuery = true)
    @Transactional
    void crearAuditoria(@Param("accion") String accion, @Param("tabla_afectada") String tabla_afectada, @Param("detalle_accion") String detalle_accion, @Param("fecha") Date fecha, @Param("dni_usuario") int dni_usuario);

    @Query("SELECT a FROM auditoria a WHERE a.dni_usuario.dni = :dni_usuario")
    List<Auditoria> findByUsuarioDni(@Param("dni_usuario") int dni_usuario);

}
