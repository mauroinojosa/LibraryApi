package com.project.BibliotecaAPI.controllers;

import com.project.BibliotecaAPI.dtos.requestDTO.EmprestimoRequestDTO;
import com.project.BibliotecaAPI.dtos.responseDTO.EmprestimoResponseDTO;
import com.project.BibliotecaAPI.services.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/emprestimo")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping("/emitir-emprestimo")
    public ResponseEntity<EmprestimoResponseDTO> emitirEmprestimo(@RequestBody EmprestimoRequestDTO emprestimoRequestDTO) {
        EmprestimoResponseDTO responseDTO = emprestimoService.emitirEmprestimo(emprestimoRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("buscar-emprestimo")
    public ResponseEntity<List<EmprestimoResponseDTO>> buscarEmprestimos() {
        List<EmprestimoResponseDTO> emprestimos = emprestimoService.buscarEmprestimos();
        return ResponseEntity.ok(emprestimos);
    }

    @GetMapping("/buscar-emprestimo/{id}")
    public ResponseEntity<EmprestimoResponseDTO> buscarEmprestimoPorId(@PathVariable Long id) {
        EmprestimoResponseDTO responseDTO = emprestimoService.buscarEmprestimoPorId(id);
        if (responseDTO != null) {
            return ResponseEntity.ok(responseDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/atualizar-emprestimo/{id}")
    public ResponseEntity<EmprestimoResponseDTO> atualizarEmprestimo(@PathVariable Long id, @RequestBody EmprestimoRequestDTO emprestimoRequestDTO) {
        EmprestimoResponseDTO responseDTO = emprestimoService.atualizarEmprestimo(id, emprestimoRequestDTO);
        if (responseDTO != null) {
            return ResponseEntity.ok(responseDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleta-emprestimo/{id}")
    public ResponseEntity<Void> deletarEmprestimo(@PathVariable Long id) {
        emprestimoService.deletarEmprestimo(id);
        return ResponseEntity.noContent().build();
    }
}
