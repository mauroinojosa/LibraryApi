package com.project.BibliotecaAPI.dtos.responseDTO;

import com.project.BibliotecaAPI.models.LivroModel;
import com.project.BibliotecaAPI.models.UsuarioModel;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.sql.Date;


@Data
public class EmprestimoResponseDTO {

    @NotBlank
    private Long emprestimoId;
    @NotBlank
    private UsuarioModel usuarioModel;
    @NotBlank
    private LivroModel livroModel;
    @NotBlank
    private Date dataInicial;
    @NotBlank
    private Date dataFinal;
}