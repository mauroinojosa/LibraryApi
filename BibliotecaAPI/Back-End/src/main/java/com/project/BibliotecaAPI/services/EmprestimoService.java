package com.project.BibliotecaAPI.services;

import com.project.BibliotecaAPI.dtos.requestDTO.EmprestimoRequestDTO;
import com.project.BibliotecaAPI.dtos.responseDTO.EmprestimoResponseDTO;
import com.project.BibliotecaAPI.models.EmprestimoModel;
import com.project.BibliotecaAPI.models.LivroModel;
import com.project.BibliotecaAPI.models.UsuarioModel;
import com.project.BibliotecaAPI.repositories.EmprestimoRepository;
import com.project.BibliotecaAPI.repositories.LivroRepository;
import com.project.BibliotecaAPI.repositories.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LivroRepository livroRepository;

    public EmprestimoResponseDTO createEmprestimo(EmprestimoRequestDTO emprestimoRequestDTO) {
        Optional<UsuarioModel> usuarioOpt = usuarioRepository.findById(emprestimoRequestDTO.getUsuarioId());
        Optional<LivroModel> livroOpt = livroRepository.findById(emprestimoRequestDTO.getLivroId());

        if (usuarioOpt.isPresent() && livroOpt.isPresent()) {
            EmprestimoModel emprestimoModel = new EmprestimoModel();
            BeanUtils.copyProperties(emprestimoRequestDTO, emprestimoModel, "usuarioModel", "livroModel");
            emprestimoModel.setUsuarioModel(usuarioOpt.get());
            emprestimoModel.setLivroModel(livroOpt.get());
            emprestimoModel = emprestimoRepository.save(emprestimoModel);

            EmprestimoResponseDTO responseDTO = new EmprestimoResponseDTO();
            BeanUtils.copyProperties(emprestimoModel, responseDTO);
            responseDTO.setNomeCompletoUsuario(usuarioOpt.get().getNomeCompletoUsuario());
            responseDTO.setTituloLivro(livroOpt.get().getTitulo());
            return responseDTO;
        } else {
            return null; // ou lançar uma exceção customizada
        }
    }

    public List<EmprestimoResponseDTO> getAllEmprestimos() {
        List<EmprestimoModel> emprestimos = emprestimoRepository.findAll();
        return emprestimos.stream().map(this::getEmprestimoResponseDTO).collect(Collectors.toList());
    }

    public EmprestimoResponseDTO getEmprestimoById(Long id) {
        Optional<EmprestimoModel> emprestimoOpt = emprestimoRepository.findById(id);
        if (emprestimoOpt.isPresent()) {
            return getEmprestimoResponseDTO(emprestimoOpt.get());
        } else {
            return null; // ou lançar uma exceção customizada
        }
    }

    public boolean deletarEmprestimo(Long id) {
        if (emprestimoRepository.existsById(id)) {
            emprestimoRepository.deleteById(id);
            return true;
        } else {
            return false; // ou lançar uma exceção customizada
        }
    }

    public EmprestimoResponseDTO editarEmprestimo(Long id, EmprestimoRequestDTO emprestimoRequestDTO) {
        Optional<EmprestimoModel> emprestimoOpt = emprestimoRepository.findById(id);
        if (emprestimoOpt.isPresent()) {
            EmprestimoModel emprestimoModel = emprestimoOpt.get();
            BeanUtils.copyProperties(emprestimoRequestDTO, emprestimoModel, "usuarioModel", "livroModel");
            Optional<UsuarioModel> usuarioOpt = usuarioRepository.findById(emprestimoRequestDTO.getUsuarioId());
            Optional<LivroModel> livroOpt = livroRepository.findById(emprestimoRequestDTO.getLivroId());

            if (usuarioOpt.isPresent() && livroOpt.isPresent()) {
                emprestimoModel.setUsuarioModel(usuarioOpt.get());
                emprestimoModel.setLivroModel(livroOpt.get());
                emprestimoModel = emprestimoRepository.save(emprestimoModel);

                EmprestimoResponseDTO responseDTO = new EmprestimoResponseDTO();
                BeanUtils.copyProperties(emprestimoModel, responseDTO);
                responseDTO.setNomeCompletoUsuario(usuarioOpt.get().getNomeCompletoUsuario());
                responseDTO.setTituloLivro(livroOpt.get().getTitulo());
                return responseDTO;
            }
        }
        return null; // ou lançar uma exceção customizada
    }

    private EmprestimoResponseDTO getEmprestimoResponseDTO(EmprestimoModel emprestimoModel) {
        EmprestimoResponseDTO responseDTO = new EmprestimoResponseDTO();
        BeanUtils.copyProperties(emprestimoModel, responseDTO);
        if (emprestimoModel.getUsuarioModel() != null) {
            responseDTO.setNomeCompletoUsuario(emprestimoModel.getUsuarioModel().getNomeCompletoUsuario());
        }
        if (emprestimoModel.getLivroModel() != null) {
            responseDTO.setTituloLivro(emprestimoModel.getLivroModel().getTitulo());
        }
        return responseDTO;
    }

    public List<UsuarioModel> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public List<LivroModel> getAllLivros() {
        return livroRepository.findAll();
    }
}
