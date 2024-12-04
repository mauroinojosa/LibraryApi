package com.project.BibliotecaAPI.dtos.responseDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.Data;

import java.sql.Date;

@Data
public class EmprestimoResponseDTO {
    @NotBlank
    private Long id;
    @Null
    private String nomeCompletoUsuario;
    @Null
    private String tituloLivro;
    @NotBlank
    private Date dataInicial;
    @NotBlank
    private Date dataFinal;




}
