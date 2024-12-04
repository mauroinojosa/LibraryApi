package com.project.BibliotecaAPI.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;


@Data
@Entity
@Table(name = "tb_usuario")
public class UsuarioModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long usuarioId;
    @Column
    private String nomeCompletoUsuario;
    @Column
    private String emailUsuario;
    @Column
    private String senhaUsuario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioModel", fetch = FetchType.EAGER)
    private List<EmprestimoModel> emprestimoModel;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioModel", fetch = FetchType.EAGER)
    private List<EnderecoModel> enderecoModel;

}