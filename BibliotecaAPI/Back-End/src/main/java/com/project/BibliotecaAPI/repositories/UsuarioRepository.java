package com.project.BibliotecaAPI.repositories;

import com.project.BibliotecaAPI.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByEmailUsuario(String emailUsuario);
    boolean existsByEmailUsuario(String emailUsuario);
}
