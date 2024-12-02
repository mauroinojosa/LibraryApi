package com.project.BibliotecaAPI.dtos.requestDTO;

import com.project.BibliotecaAPI.models.EnderecoModel;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioRequestDTO {

    @NotBlank
    private String nomeCompletoUsuario;

    @NotBlank
    private String emailUsuario;

    @NotBlank
    private String senhaUsuario;

    @NotBlank
    private EnderecoModel enderecoModel;
}
