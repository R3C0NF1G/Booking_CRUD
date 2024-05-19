package com.edu.unbosque.ch0ch4l1t0.service;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Auditoria;
import com.edu.unbosque.ch0ch4l1t0.repository.AuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AuditoriaService {

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    public List<Auditoria> findAll() {
        return auditoriaRepository.findAll();
    }

    public Optional<Auditoria> findById(int id) {
        return auditoriaRepository.findById(id);
    }

    public Auditoria save(Auditoria auditoria) {
        return auditoriaRepository.save(auditoria);
    }

    public void deleteById(int id) {
        auditoriaRepository.deleteById(id);
    }

    public List<Auditoria> findByUsuarioDni(int dniUsuario) {
        return auditoriaRepository.findByUsuarioDni(dniUsuario);
    }

    public void crearAuditoria(String accion, String tablaAfectada, String detalleAccion, Date fecha, int dniUsuario) {
        auditoriaRepository.crearAuditoria(accion, tablaAfectada, detalleAccion, fecha, dniUsuario);
    }
}
