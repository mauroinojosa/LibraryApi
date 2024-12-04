package com.project.BibliotecaAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;


@Data
@Entity
@Table(name = "tb_emprestimo")
public class EmprestimoModel implements Serializable {
   @Serial
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long emprestimoId;

   @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
   @JoinColumn(name = "fk_usuario")
   private UsuarioModel usuarioModel;

   @JoinColumn(name = "fk_livro")
   @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
   private LivroModel livroModel;

   @Column
   private Date dataInicial;
   @Column
   private Date dataFinal;
}

