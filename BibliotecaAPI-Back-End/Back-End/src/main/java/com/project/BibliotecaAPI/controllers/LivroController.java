package com.project.BibliotecaAPI.controllers;

import com.project.BibliotecaAPI.dtos.requestDTO.LivroRequestDTO;
import com.project.BibliotecaAPI.dtos.responseDTO.LivroResponseDTO;
import com.project.BibliotecaAPI.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping("/cadastrar-livro")
    public ResponseEntity<LivroResponseDTO> cadastrarLivro(@RequestBody LivroRequestDTO livroRequestDTO) {
        LivroResponseDTO livroCriado = livroService.cadastrarLivro(livroRequestDTO);
        return ResponseEntity.status(201).body(livroCriado);
    }

    @GetMapping("/buscar-livro")
    public ResponseEntity<List<LivroResponseDTO>> buscarTodosLivros() {
        List<LivroResponseDTO> livros = livroService.buscarLivros();
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/buscar-livro/{id}")
    public ResponseEntity<LivroResponseDTO> buscarLivroPorId(@PathVariable Long id) {
        Optional<LivroResponseDTO> livro = livroService.buscarLivroPorId(id);
        return livro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/atualizar-livro/{id}")
    public ResponseEntity<LivroResponseDTO> atualizarLivro(@PathVariable Long id, @RequestBody LivroRequestDTO livroRequestDTO) {
        Optional<LivroResponseDTO> livroAtualizado = livroService.atualizarLivro(id, livroRequestDTO);
        return livroAtualizado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deletar-livro/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        if (livroService.deletarLivro(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

