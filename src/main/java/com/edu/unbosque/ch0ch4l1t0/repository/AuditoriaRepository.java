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
    @Query(value = "INSERT INTO Auditoria (accion, tabla_afectada, detalle_accion, fecha, dni_usuario) VALUES (:accion, :tablaAfectada, :detalleAccion, :fecha, :dniUsuario)", nativeQuery = true)
    @Transactional
    void crearAuditoria(@Param("accion") String accion, @Param("tablaAfectada") String tablaAfectada, @Param("detalleAccion") String detalleAccion, @Param("fecha") Date fecha, @Param("dniUsuario") int dniUsuario);

    @Query("SELECT a FROM Auditoria a WHERE a.dniUsuario.dni = :dniUsuario")
    List<Auditoria> findByUsuarioDni(@Param("dniUsuario") int dniUsuario);

}
