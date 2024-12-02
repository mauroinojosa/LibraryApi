package com.project.BibliotecaAPI.dtos.responseDTO;

import com.project.BibliotecaAPI.models.EmprestimoModel;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.sql.Date;
import java.util.List;


@Data
public class LivroResponseDTO {

    @NotBlank
    private Long livroId;
    @NotBlank
    private String titulo;
    @NotBlank
    private String autor;
    @NotBlank
    private Date anoPublicacao;

    private List<EmprestimoModel> emprestimoModel;
}
