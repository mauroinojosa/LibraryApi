package com.project.BibliotecaAPI.controllers;

import com.project.BibliotecaAPI.dtos.requestDTO.UsuarioRequestDTO;
import com.project.BibliotecaAPI.dtos.responseDTO.UsuarioResponseDTO;
import com.project.BibliotecaAPI.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioWebController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new UsuarioRequestDTO());
        return "html/user/formularioCadastro";
    }

    @PostMapping("/salvar")
    public String salvarUsuario(@ModelAttribute UsuarioRequestDTO usuarioRequestDTO) {
        usuarioService.cadastrarUsuario(usuarioRequestDTO);
        return "redirect:/usuario";
    }

    @GetMapping
    public String listarUsuarios(Model model) {
        List<UsuarioResponseDTO> usuarios = usuarioService.buscarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "html/user/usuario";
    }

    @GetMapping("/buscar")
    public String buscarUsuarioPorId(@RequestParam("usuarioId") Long id, Model model) {
        UsuarioResponseDTO usuario = usuarioService.buscarUsuarioPorId(id);
        model.addAttribute("usuarios", List.of(usuario));
        return "html/user/usuario";
    }

    @GetMapping("/atualizar/{id}")
    public String mostrarFormularioAtualizacao(@PathVariable("id") Long id, Model model) {
        UsuarioResponseDTO usuario = usuarioService.buscarUsuarioPorId(id);
        model.addAttribute("usuario", usuario);
        return "html/user/formularioAtualizacao";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarUsuario(@PathVariable("id") Long id, @ModelAttribute UsuarioRequestDTO usuarioRequestDTO) {
        usuarioService.atualizarUsuario(id, usuarioRequestDTO);
        return "redirect:/usuario";
    }

    @PostMapping("/apagar/{id}")
    public String apagarUsuario(@PathVariable("id") Long id) {
        usuarioService.deletarUsuario(id);
        return "redirect:/usuario";
    }
}
