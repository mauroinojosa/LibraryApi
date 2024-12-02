package com.project.BibliotecaAPI.services;

import com.project.BibliotecaAPI.dtos.requestDTO.LivroRequestDTO;
import com.project.BibliotecaAPI.dtos.responseDTO.LivroResponseDTO;
import com.project.BibliotecaAPI.models.LivroModel;
import com.project.BibliotecaAPI.repositories.LivroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public LivroResponseDTO cadastrarLivro(LivroRequestDTO livroRequestDTO) {
        LivroModel livroModel = new LivroModel();
        BeanUtils.copyProperties(livroRequestDTO, livroModel);
        LivroModel livroSalvo = livroRepository.save(livroModel);

        LivroResponseDTO livroResponseDTO = new LivroResponseDTO();
        BeanUtils.copyProperties(livroSalvo, livroResponseDTO);
        return livroResponseDTO;
    }

    public List<LivroResponseDTO> buscarLivros() {
        List<LivroModel> livros = livroRepository.findAll();
        return livros.stream().map(livro -> {
            LivroResponseDTO livroResponseDTO = new LivroResponseDTO();
            BeanUtils.copyProperties(livro, livroResponseDTO);
            return livroResponseDTO;
        }).collect(Collectors.toList());
    }

    public Optional<LivroResponseDTO> buscarLivroPorId(Long id) {
        Optional<LivroModel> livroModel = livroRepository.findById(id);
        if (livroModel.isPresent()) {
            LivroResponseDTO livroResponseDTO = new LivroResponseDTO();
            BeanUtils.copyProperties(livroModel.get(), livroResponseDTO);
            return Optional.of(livroResponseDTO);
        }
        return Optional.empty();
    }

    public Optional<LivroResponseDTO> atualizarLivro(Long id, LivroRequestDTO livroRequestDTO) {
        Optional<LivroModel> livroExistente = livroRepository.findById(id);
        if (livroExistente.isPresent()) {
            LivroModel livroModel = livroExistente.get();
            BeanUtils.copyProperties(livroRequestDTO, livroModel, "livroId");
            LivroModel livroAtualizado = livroRepository.save(livroModel);

            LivroResponseDTO livroResponseDTO = new LivroResponseDTO();
            BeanUtils.copyProperties(livroAtualizado, livroResponseDTO);
            return Optional.of(livroResponseDTO);
        }
        return Optional.empty();
    }

    public boolean deletarLivro(Long id) {
        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
