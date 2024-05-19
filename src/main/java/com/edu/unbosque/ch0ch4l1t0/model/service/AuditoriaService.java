package com.edu.unbosque.ch0ch4l1t0.model.service;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Auditoria;
import com.edu.unbosque.ch0ch4l1t0.model.repository.AuditoriaRepository;
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

    public List<Auditoria> findByUsuarioDni(int dni_usuario) {
        return auditoriaRepository.findByUsuarioDni(dni_usuario);
    }

    public void crearAuditoria(String accion, String tabla_afectada, String detalle_accion, Date fecha, int dni_usuario) {
        auditoriaRepository.crearAuditoria(accion, tabla_afectada, detalle_accion, fecha, dni_usuario);
    }
}
