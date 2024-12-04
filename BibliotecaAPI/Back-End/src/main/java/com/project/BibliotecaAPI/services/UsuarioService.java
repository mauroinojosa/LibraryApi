package com.project.BibliotecaAPI.services;

import com.project.BibliotecaAPI.dtos.requestDTO.UsuarioRequestDTO;
import com.project.BibliotecaAPI.dtos.responseDTO.UsuarioResponseDTO;
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

    public UsuarioResponseDTO cadastrarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        UsuarioModel usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioRequestDTO, usuarioModel);
        UsuarioModel usuarioSalvo = usuarioRepository.save(usuarioModel);

        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
        BeanUtils.copyProperties(usuarioSalvo, usuarioResponseDTO);
        return usuarioResponseDTO;
    }

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

    public UsuarioResponseDTO buscarUsuarioPorId(Long id) {
        Optional<UsuarioModel> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
            BeanUtils.copyProperties(usuarioOpt.get(), usuarioResponseDTO);
            return usuarioResponseDTO;
        }
        return null;
    }

    public UsuarioResponseDTO atualizarUsuario(Long id, UsuarioRequestDTO usuarioRequestDTO) {
        Optional<UsuarioModel> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            UsuarioModel usuarioModel = usuarioOpt.get();
            BeanUtils.copyProperties(usuarioRequestDTO, usuarioModel, "id");
            UsuarioModel usuarioAtualizado = usuarioRepository.save(usuarioModel);

            UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
            BeanUtils.copyProperties(usuarioAtualizado, usuarioResponseDTO);
            return usuarioResponseDTO;
        }
        return null;
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
