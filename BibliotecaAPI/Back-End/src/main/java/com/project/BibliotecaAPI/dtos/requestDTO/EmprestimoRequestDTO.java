package com.project.BibliotecaAPI.dtos.requestDTO;

import com.project.BibliotecaAPI.models.LivroModel;
import com.project.BibliotecaAPI.models.UsuarioModel;

import lombok.Data;
import lombok.Getter;

import java.sql.Date;

@Data
public class EmprestimoRequestDTO {

    private UsuarioModel usuarioModel;
    private Long usuarioId;
    private Long livroId;
    private LivroModel livroModel;

    private Date dataInicial;

    private Date dataFinal;

}