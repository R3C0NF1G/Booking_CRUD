package com.edu.unbosque.ch0ch4l1t0.repository;

import com.edu.unbosque.ch0ch4l1t0.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT u FROM usuario u WHERE u.email = :email")
    Usuario findByEmail(@Param("email") String email);

    @Query("SELECT u FROM usuario u WHERE u.rol.id = :rolId")
    List<Usuario> findByRolId(@Param("rol_id") int rol_id);

}