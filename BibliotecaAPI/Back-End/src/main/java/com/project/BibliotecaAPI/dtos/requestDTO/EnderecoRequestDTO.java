package com.project.BibliotecaAPI.dtos.requestDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EnderecoRequestDTO {

    @NotBlank
    private String rua;
    @NotBlank
    private String numeroCasa;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cidade;
}
