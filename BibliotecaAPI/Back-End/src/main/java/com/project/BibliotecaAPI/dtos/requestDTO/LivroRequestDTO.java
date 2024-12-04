package com.project.BibliotecaAPI.dtos.requestDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.sql.Date;

@Data
public class LivroRequestDTO {

    @NotBlank
    private String titulo;
    @NotBlank
    private String autor;
    @NotBlank
    private Date anoPublicacao;

}
