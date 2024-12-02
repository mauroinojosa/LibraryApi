package com.project.BibliotecaAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tb_livro")
public class LivroModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long livroId;
    @Column
    private String titulo;
    @Column
    private String autor;
    @Column(name = "ano_publicacao")
    private Date anoPublicacao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "livroModel", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<EmprestimoModel> emprestimoModel;
}
