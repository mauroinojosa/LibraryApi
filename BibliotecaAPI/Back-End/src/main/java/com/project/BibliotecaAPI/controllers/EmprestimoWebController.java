package com.project.BibliotecaAPI.controllers;

import com.project.BibliotecaAPI.dtos.requestDTO.EmprestimoRequestDTO;
import com.project.BibliotecaAPI.dtos.responseDTO.EmprestimoResponseDTO;
import com.project.BibliotecaAPI.services.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoWebController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public String getAllEmprestimos(Model model) {
        List<EmprestimoResponseDTO> emprestimos = emprestimoService.getAllEmprestimos();
        model.addAttribute("emprestimos", emprestimos);
        return "html/loan/emprestimos";
    }

    @PostMapping("/deletar")
    public String deletarEmprestimo(@RequestParam Long id) {
        boolean deletado = emprestimoService.deletarEmprestimo(id);
        if (deletado) {
            return "redirect:/emprestimos";
        } else {
            // Adicione um tratamento de erro apropriado aqui
            return "error";
        }
    }

    @GetMapping("/editar/{id}")
    public String editarEmprestimoForm(@PathVariable Long id, Model model) {
        EmprestimoResponseDTO emprestimo = emprestimoService.getEmprestimoById(id);
        if (emprestimo != null) {
            model.addAttribute("emprestimo", emprestimo);
            model.addAttribute("usuarios", emprestimoService.getAllUsuarios());
            model.addAttribute("livros", emprestimoService.getAllLivros());
            return "html/loan/editar-emprestimo";
        } else {
            // Adicionar uma mensagem de erro ou redirecionar para uma página de erro
            return "error";
        }
    }

    @PostMapping("/editar/{id}")
    public String editarEmprestimo(@PathVariable Long id, @Validated @ModelAttribute EmprestimoRequestDTO emprestimoRequestDTO) {
        EmprestimoResponseDTO emprestimo = emprestimoService.editarEmprestimo(id, emprestimoRequestDTO);
        if (emprestimo != null) {
            return "redirect:/emprestimos";
        } else {
            // Adicione um tratamento de erro apropriado aqui
            return "error";
        }
    }

    @GetMapping("/novo")
    public String novoEmprestimoForm(Model model) {
        model.addAttribute("emprestimoRequestDTO", new EmprestimoRequestDTO());
        model.addAttribute("usuarios", emprestimoService.getAllUsuarios());
        model.addAttribute("livros", emprestimoService.getAllLivros());
        return "html/loan/novo-emprestimo";
    }

    @PostMapping
    public String createEmprestimo(@Validated @ModelAttribute EmprestimoRequestDTO emprestimoRequestDTO) {
        emprestimoService.createEmprestimo(emprestimoRequestDTO);
        return "redirect:/emprestimos";
    }
}
