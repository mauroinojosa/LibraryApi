package com.project.BibliotecaAPI.controllers;

import com.project.BibliotecaAPI.dtos.requestDTO.EnderecoRequestDTO;
import com.project.BibliotecaAPI.dtos.responseDTO.EnderecoResponseDTO;
import com.project.BibliotecaAPI.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/cadastrar-endereco")
    public ResponseEntity<EnderecoResponseDTO> cadastrarEndereco(@RequestBody EnderecoRequestDTO enderecoRequestDTO) {
        EnderecoResponseDTO responseDTO = enderecoService.cadastrarEndereco(enderecoRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/buscar-endereco")
    public ResponseEntity<List<EnderecoResponseDTO>> buscarTodosEnderecos() {
        List<EnderecoResponseDTO> enderecos = enderecoService.buscarEnderecos();
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("/buscar-endereco/{id}")
    public ResponseEntity<EnderecoResponseDTO> buscarEnderecoPorId(@PathVariable Long id) {
        EnderecoResponseDTO responseDTO = enderecoService.buscarEnderecoPorId(id);
        if (responseDTO != null) {
            return ResponseEntity.ok(responseDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/atualizar-endereco/{id}")
    public ResponseEntity<EnderecoResponseDTO> atualizarEndereco(@PathVariable Long id, @RequestBody EnderecoRequestDTO enderecoRequestDTO) {
        EnderecoResponseDTO responseDTO = enderecoService.atualizarEndereco(id, enderecoRequestDTO);
        if (responseDTO != null) {
            return ResponseEntity.ok(responseDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletar-endereco/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id) {
        enderecoService.deletarEndereco(id);
        return ResponseEntity.noContent().build();
    }
}
