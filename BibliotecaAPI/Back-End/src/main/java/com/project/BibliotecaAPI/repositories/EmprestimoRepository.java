package com.project.BibliotecaAPI.repositories;

import com.project.BibliotecaAPI.models.EmprestimoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<EmprestimoModel,Long> {
}
