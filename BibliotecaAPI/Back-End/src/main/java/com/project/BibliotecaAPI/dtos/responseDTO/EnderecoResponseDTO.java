package com.project.BibliotecaAPI.dtos.responseDTO;

import com.project.BibliotecaAPI.models.UsuarioModel;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EnderecoResponseDTO {

    @NotBlank
    private Long enderecoId;
    @NotBlank
    private String rua;
    @NotBlank
    private String numeroCasa;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cidade;
    @NotBlank
    private UsuarioModel usuarioModel;
}
