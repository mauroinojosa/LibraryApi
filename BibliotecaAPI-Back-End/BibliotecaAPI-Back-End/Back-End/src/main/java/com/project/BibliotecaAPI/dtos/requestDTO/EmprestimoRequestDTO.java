package com.project.BibliotecaAPI.dtos.requestDTO;

import com.project.BibliotecaAPI.models.LivroModel;
import com.project.BibliotecaAPI.models.UsuarioModel;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;

import java.sql.Date;
import java.util.List;

@Data
public class EmprestimoRequestDTO {

    @NotBlank
    @Getter
    private UsuarioModel usuarioModel;
    @Getter
    @NotBlank
    private LivroModel livroModel;
    @NotBlank
    private Date dataInicial;
    @NotBlank
    private Date dataFinal;
}