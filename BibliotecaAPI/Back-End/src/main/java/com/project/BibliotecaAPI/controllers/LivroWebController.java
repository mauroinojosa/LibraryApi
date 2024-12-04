package com.project.BibliotecaAPI.controllers;

import com.project.BibliotecaAPI.dtos.requestDTO.LivroRequestDTO;
import com.project.BibliotecaAPI.dtos.responseDTO.LivroResponseDTO;
import com.project.BibliotecaAPI.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/livro")
public class LivroWebController {
    @Autowired
    private LivroService livroService;

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("livro", new LivroResponseDTO());
        return "html/book/formularioCadastro";
    }

    @PostMapping("/salvar")
    public String salvarLivro(@ModelAttribute LivroRequestDTO livroRequestDTO) {
        livroService.cadastrarLivro(livroRequestDTO);
        return "redirect:/livro";
    }

    @GetMapping("")
    public String listarLivros(Model model) {
        List<LivroResponseDTO> livro = livroService.buscarLivros();
        model.addAttribute("livro", livro);
        return "html/book/livro";
    }

    @GetMapping("/buscar")
    public String buscarLivroPorId(@RequestParam("livroID") Long id, Model model) {
      LivroResponseDTO livro = livroService.buscarLivroPorId(id);
        model.addAttribute("livro", List.of(livro));
        return "/html/book/livro";
    }

    @GetMapping("/atualizar/{id}")
    public String mostrarFormularioAtualizacao(@PathVariable("id") Long id, Model model) {
       LivroResponseDTO livro = livroService.buscarLivroPorId(id);
        model.addAttribute("livro", livro);
        return "html/book/formularioAtualizacao";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarLivro(@PathVariable("id") Long id, @ModelAttribute LivroRequestDTO livroRequestDTO) {
        livroService.atualizarLivro(id, livroRequestDTO);
        return "redirect:/livro";
    }

    @PostMapping("/apagar/{id}")
    public String apagarLivro(@PathVariable("id") Long id) {
        livroService.deletarLivro(id);
        return "redirect:/livro";
    }
}
