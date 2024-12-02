package com.project.BibliotecaAPI.services;

import com.project.BibliotecaAPI.dtos.responseDTO.EnderecoResponseDTO;
import com.project.BibliotecaAPI.dtos.requestDTO.EnderecoRequestDTO;
import com.project.BibliotecaAPI.models.EnderecoModel;
import com.project.BibliotecaAPI.repositories.EnderecoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    // Criar novo endereço
    public EnderecoResponseDTO cadastrarEndereco(EnderecoRequestDTO enderecoRequestDTO) {
        EnderecoModel enderecoModel = new EnderecoModel();
        BeanUtils.copyProperties(enderecoRequestDTO, enderecoModel);
        EnderecoModel enderecoSalvo = enderecoRepository.save(enderecoModel);

        // Convertendo para EnderecoResponseDTO antes de retornar ao controlador
        EnderecoResponseDTO enderecoResponseDTO = new EnderecoResponseDTO();
        BeanUtils.copyProperties(enderecoSalvo, enderecoResponseDTO);
        return enderecoResponseDTO;
    }

    // Buscar todos os endereços
    public List<EnderecoResponseDTO> buscarEnderecos() {
        List<EnderecoModel> enderecos = enderecoRepository.findAll();
        return enderecos.stream()
                .map(endereco -> {
                    EnderecoResponseDTO enderecoResponseDTO = new EnderecoResponseDTO();
                    BeanUtils.copyProperties(endereco, enderecoResponseDTO);
                    return enderecoResponseDTO;
                })
                .toList();
    }

    // Buscar endereço por ID
    public EnderecoResponseDTO buscarEnderecoPorId(Long id) {
        Optional<EnderecoModel> enderecoOpt = enderecoRepository.findById(id);
        if (enderecoOpt.isPresent()) {
            EnderecoResponseDTO enderecoResponseDTO = new EnderecoResponseDTO();
            BeanUtils.copyProperties(enderecoOpt.get(), enderecoResponseDTO);
            return enderecoResponseDTO;
        }
        return null;  // ou lançar exceção de "Endereço não encontrado"
    }

    // Atualizar endereço
    public EnderecoResponseDTO atualizarEndereco(Long id, EnderecoRequestDTO enderecoRequestDTO) {
        Optional<EnderecoModel> enderecoOpt = enderecoRepository.findById(id);
        if (enderecoOpt.isPresent()) {
            EnderecoModel enderecoModel = enderecoOpt.get();
            BeanUtils.copyProperties(enderecoRequestDTO, enderecoModel, "enderecoId");  // Não sobrescrever o id
            EnderecoModel enderecoAtualizado = enderecoRepository.save(enderecoModel);

            // Convertendo para EnderecoResponseDTO antes de retornar ao controlador
            EnderecoResponseDTO enderecoResponseDTO = new EnderecoResponseDTO();
            BeanUtils.copyProperties(enderecoAtualizado, enderecoResponseDTO);
            return enderecoResponseDTO;
        }
        return null;  // ou lançar exceção de "Endereço não encontrado"
    }

    // Deletar endereço
    public void deletarEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }
}
