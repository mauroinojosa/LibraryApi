package com.project.BibliotecaAPI.controllers;

import com.project.BibliotecaAPI.dtos.requestDTO.EnderecoRequestDTO;
import com.project.BibliotecaAPI.dtos.responseDTO.EnderecoResponseDTO;
import com.project.BibliotecaAPI.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/endereco")
public class EnderecoWebController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("endereco", new EnderecoRequestDTO());
        return "html/address/formularioCadastro";
    }

    @PostMapping("/salvar")
    public String salvarEndereco(@ModelAttribute EnderecoRequestDTO enderecoRequestDTO) {
        enderecoService.cadastrarEndereco(enderecoRequestDTO);
        return "redirect:/endereco";
    }

    @GetMapping
    public String listarEnderecos(Model model) {
        List<EnderecoResponseDTO> enderecos = enderecoService.buscarEnderecos();
        model.addAttribute("enderecos", enderecos);
        return "/html/address/endereco";
    }

    @GetMapping("/buscar")
    public String buscarEnderecoPorId(@RequestParam("enderecoId") Long id, Model model) {
        EnderecoResponseDTO endereco = enderecoService.buscarEnderecoPorId(id);
        model.addAttribute("enderecos", List.of(endereco));
        return "/html/address/endereco";
    }

    @GetMapping("/atualizar/{id}")
    public String mostrarFormularioAtualizacao(@PathVariable("id") Long id, Model model) {
        EnderecoResponseDTO endereco = enderecoService.buscarEnderecoPorId(id);
        model.addAttribute("endereco", endereco);
        return "/html/address/formularioAtualizacao";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarEndereco(@PathVariable("id") Long id, @ModelAttribute EnderecoRequestDTO enderecoRequestDTO) {
        enderecoService.atualizarEndereco(id, enderecoRequestDTO);
        return "redirect:/endereco";
    }

    @PostMapping("/apagar/{id}")
    public String apagarEndereco(@PathVariable("id") Long id) {
        enderecoService.deletarEndereco(id);
        return "redirect:/endereco";
    }
}


