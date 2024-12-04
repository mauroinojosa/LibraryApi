package com.project.BibliotecaAPI.repositories;

import com.project.BibliotecaAPI.models.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<EnderecoModel,Long> {
}
