package com.project.BibliotecaAPI.services;

import com.project.BibliotecaAPI.dtos.responseDTO.EmprestimoResponseDTO;
import com.project.BibliotecaAPI.dtos.requestDTO.EmprestimoRequestDTO;
import com.project.BibliotecaAPI.models.EmprestimoModel;
import com.project.BibliotecaAPI.models.UsuarioModel;
import com.project.BibliotecaAPI.models.LivroModel;
import com.project.BibliotecaAPI.repositories.EmprestimoRepository;
import com.project.BibliotecaAPI.repositories.UsuarioRepository;
import com.project.BibliotecaAPI.repositories.LivroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LivroRepository livroRepository;

    // Criar novo empréstimo
    public EmprestimoResponseDTO emitirEmprestimo(EmprestimoRequestDTO emprestimoRequestDTO) {
        EmprestimoModel emprestimoModel = new EmprestimoModel();

        // Buscar e definir o usuário
        UsuarioModel usuario = usuarioRepository.findById(emprestimoRequestDTO.getUsuarioModel().getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        emprestimoModel.setUsuarioModel(usuario);

        // Buscar e definir o livro
        LivroModel livro = livroRepository.findById(emprestimoRequestDTO.getLivroModel().getLivroId())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        emprestimoModel.setLivroModel(livro);

        // Copiar propriedades restantes do DTO para o model
        emprestimoModel.setDataInicial(emprestimoRequestDTO.getDataInicial());
        emprestimoModel.setDataFinal(emprestimoRequestDTO.getDataFinal());

        EmprestimoModel emprestimoSalvo = emprestimoRepository.save(emprestimoModel);

        // Convertendo para EmprestimoResponseDTO antes de retornar ao controlador
        EmprestimoResponseDTO emprestimoResponseDTO = new EmprestimoResponseDTO();
        BeanUtils.copyProperties(emprestimoSalvo, emprestimoResponseDTO);
        emprestimoResponseDTO.setUsuarioModel(usuario);
        emprestimoResponseDTO.setLivroModel(livro);
        return emprestimoResponseDTO;
    }

    // Buscar todos os empréstimos
    public List<EmprestimoResponseDTO> buscarEmprestimos() {
        List<EmprestimoModel> emprestimos = emprestimoRepository.findAll();
        return emprestimos.stream()
                .map(emprestimo -> {
                    EmprestimoResponseDTO emprestimoResponseDTO = new EmprestimoResponseDTO();
                    BeanUtils.copyProperties(emprestimo, emprestimoResponseDTO);
                    emprestimoResponseDTO.setUsuarioModel(emprestimo.getUsuarioModel());
                    emprestimoResponseDTO.setLivroModel(emprestimo.getLivroModel());
                    return emprestimoResponseDTO;
                })
                .toList();
    }

    // Buscar empréstimo por ID
    public EmprestimoResponseDTO buscarEmprestimoPorId(Long id) {
        EmprestimoModel emprestimo = emprestimoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));
        EmprestimoResponseDTO emprestimoResponseDTO = new EmprestimoResponseDTO();
        BeanUtils.copyProperties(emprestimo, emprestimoResponseDTO);
        emprestimoResponseDTO.setUsuarioModel(emprestimo.getUsuarioModel());
        emprestimoResponseDTO.setLivroModel(emprestimo.getLivroModel());
        return emprestimoResponseDTO;
    }

    // Atualizar empréstimo
    public EmprestimoResponseDTO atualizarEmprestimo(Long id, EmprestimoRequestDTO emprestimoRequestDTO) {
        Optional<EmprestimoModel> emprestimoOpt = emprestimoRepository.findById(id);
        if (emprestimoOpt.isPresent()) {
            EmprestimoModel emprestimoModel = emprestimoOpt.get();

            UsuarioModel usuario = usuarioRepository.findById(emprestimoRequestDTO.getUsuarioModel().getUsuarioId())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
            emprestimoModel.setUsuarioModel(usuario);

            LivroModel livro = livroRepository.findById(emprestimoRequestDTO.getLivroModel().getLivroId())
                    .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
            emprestimoModel.setLivroModel(livro);

            emprestimoModel.setDataInicial(emprestimoRequestDTO.getDataInicial());
            emprestimoModel.setDataFinal(emprestimoRequestDTO.getDataFinal());

            EmprestimoModel emprestimoAtualizado = emprestimoRepository.save(emprestimoModel);

            EmprestimoResponseDTO emprestimoResponseDTO = new EmprestimoResponseDTO();
            BeanUtils.copyProperties(emprestimoAtualizado, emprestimoResponseDTO);
            emprestimoResponseDTO.setUsuarioModel(usuario);
            emprestimoResponseDTO.setLivroModel(livro);
            return emprestimoResponseDTO;
        }
        return null;  // ou lançar exceção de "Empréstimo não encontrado"
    }

    // Deletar empréstimo
    public void deletarEmprestimo(Long id) {
        emprestimoRepository.deleteById(id);
    }
}
