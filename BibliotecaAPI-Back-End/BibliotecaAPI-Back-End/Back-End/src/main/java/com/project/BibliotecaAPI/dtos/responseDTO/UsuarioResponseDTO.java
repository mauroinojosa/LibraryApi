package com.project.BibliotecaAPI.dtos.responseDTO;

import com.project.BibliotecaAPI.models.EmprestimoModel;
import com.project.BibliotecaAPI.models.EnderecoModel;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class UsuarioResponseDTO {

    @NotBlank
    private Long usuarioId;
    @NotBlank
    private String nomeCompletoUsuario;
    @NotBlank
    private String emailUsuario;
    @NotBlank
    private String senhaUsuario;
    @NotBlank
    private List<EmprestimoModel> emprestimoModel;
    private List<EnderecoModel> enderecoModel;
}
