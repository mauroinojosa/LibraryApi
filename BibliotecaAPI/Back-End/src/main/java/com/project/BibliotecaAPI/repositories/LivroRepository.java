package com.project.BibliotecaAPI.repositories;

import com.project.BibliotecaAPI.models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {
}
