package com.project.BibliotecaAPI.controllers;

import com.project.BibliotecaAPI.dtos.responseDTO.UsuarioResponseDTO;
import com.project.BibliotecaAPI.dtos.requestDTO.UsuarioRequestDTO;
import com.project.BibliotecaAPI.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Endpoint para cadastrar usuario
    @PostMapping("/cadastrar-usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponseDTO cadastrarUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return usuarioService.cadastrarUsuario(usuarioRequestDTO);
    }

    // Endpoint para listar todos os usuarios
    @GetMapping("/buscar-usuario")
    public List<UsuarioResponseDTO> buscarTodosUsuarios() {
        return usuarioService.buscarUsuarios();
    }

    // Endpoint para buscar usuário por ID
    @GetMapping("/buscar-usuario/{id}")
    public UsuarioResponseDTO buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.buscarUsuarioPorId(id);
    }

    // Endpoint para atualizar usuario
    @PutMapping("/atualizar-usuario/{id}")
    public UsuarioResponseDTO atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return usuarioService.atualizarUsuario(id, usuarioRequestDTO);
    }

    // Endpoint para deletar usuário
    @DeleteMapping("/deletar-usuario/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
    }
}