package com.project.BibliotecaAPI.services;

import com.project.BibliotecaAPI.dtos.responseDTO.UsuarioResponseDTO;
import com.project.BibliotecaAPI.dtos.requestDTO.UsuarioRequestDTO;
import com.project.BibliotecaAPI.models.UsuarioModel;
import com.project.BibliotecaAPI.repositories.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Criar novo usuario
    public UsuarioResponseDTO cadastrarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        UsuarioModel usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioRequestDTO, usuarioModel);
        UsuarioModel usuarioSalvo = usuarioRepository.save(usuarioModel);

        // Convertendo para UsuarioResponseDTO antes de retornar ao controlador
        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
        BeanUtils.copyProperties(usuarioSalvo, usuarioResponseDTO);
        return usuarioResponseDTO;
    }

    // Buscar todos os usuarios
    public List<UsuarioResponseDTO> buscarUsuarios() {
        List<UsuarioModel> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuario -> {
                    UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
                    BeanUtils.copyProperties(usuario, usuarioResponseDTO);
                    return usuarioResponseDTO;
                })
                .toList();
    }

    // Buscar usuário por ID
    public UsuarioResponseDTO buscarUsuarioPorId(Long id) {
        Optional<UsuarioModel> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
            BeanUtils.copyProperties(usuarioOpt.get(), usuarioResponseDTO);
            return usuarioResponseDTO;
        }
        return null;  // ou lançar exceção de "Usuário não encontrado"
    }

    // Atualizar usuário
    public UsuarioResponseDTO atualizarUsuario(Long id, UsuarioRequestDTO usuarioRequestDTO) {
        Optional<UsuarioModel> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            UsuarioModel usuarioModel = usuarioOpt.get();
            BeanUtils.copyProperties(usuarioRequestDTO, usuarioModel, "id");  // Não sobrescrever o id
            UsuarioModel usuarioAtualizado = usuarioRepository.save(usuarioModel);

            // Convertendo para UsuarioResponseDTO antes de retornar ao controlador
            UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
            BeanUtils.copyProperties(usuarioAtualizado, usuarioResponseDTO);
            return usuarioResponseDTO;
        }
        return null;  // ou lançar exceção de "Usuário não encontrado"
    }

    // Deletar usuário
    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }


}



