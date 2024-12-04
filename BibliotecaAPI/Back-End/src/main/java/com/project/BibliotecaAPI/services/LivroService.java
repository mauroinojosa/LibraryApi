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
        return livros.stream()
                .map(livro -> {
                    LivroResponseDTO livroResponseDTO = new LivroResponseDTO();
                    BeanUtils.copyProperties(livro, livroResponseDTO);
                    return livroResponseDTO;
                })
                .toList();
    }

    public LivroResponseDTO buscarLivroPorId(Long id) {
        Optional<LivroModel> livroOpt = livroRepository.findById(id);
        if (livroOpt.isPresent()) {
            LivroResponseDTO livroResponseDTO = new LivroResponseDTO();
            BeanUtils.copyProperties(livroOpt.get(), livroResponseDTO);
            return livroResponseDTO;
        }
        return null;
    }

    public LivroResponseDTO atualizarLivro(Long id, LivroRequestDTO livroRequestDTO) {
        Optional<LivroModel> livroOpt = livroRepository.findById(id);
        if (livroOpt.isPresent()) {
            LivroModel livroModel = livroOpt.get();
            BeanUtils.copyProperties(livroRequestDTO, livroModel, "livroId");
            LivroModel livroAtualizado = livroRepository.save(livroModel);

            LivroResponseDTO livroResponseDTO = new LivroResponseDTO();
            BeanUtils.copyProperties(livroAtualizado, livroResponseDTO);
            return livroResponseDTO;
        }
        return null;
    }

    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }
}
