package controlequi.com.br.controlequi.Service;

import controlequi.com.br.controlequi.Model.FuncionarioModel;
import controlequi.com.br.controlequi.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // Cadastrar um novo funcionário
    public FuncionarioModel salvarFuncionario(FuncionarioModel funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    // Listar todos os funcionários
    public List<FuncionarioModel> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    // Buscar um funcionário pelo ID
    public Optional<FuncionarioModel> buscarFuncionarioPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    // Atualizar um funcionário
    public FuncionarioModel atualizarFuncionario(Long id, FuncionarioModel funcionarioAtualizado) {
        Optional<FuncionarioModel> funcionarioExistente = funcionarioRepository.findById(id);

        if (funcionarioExistente.isPresent()) {
            FuncionarioModel funcionario = funcionarioExistente.get();
            funcionario.setNomeFuncionario(funcionarioAtualizado.getNomeFuncionario());
            funcionario.setCpfFuncionario(funcionarioAtualizado.getCpfFuncionario());
            funcionario.setCargoArea(funcionarioAtualizado.getCargoArea());
            funcionario.setStatusEmpregaticio(funcionarioAtualizado.getStatusEmpregaticio());
            funcionario.setIsTecnico(funcionarioAtualizado.getIsTecnico());
            funcionario.setEmailFuncionario(funcionarioAtualizado.getEmailFuncionario());

            return funcionarioRepository.save(funcionario);
        } else {
            return null; // ou pode lançar uma exceção personalizada
        }
    }

    // Deletar um funcionário
    public void deletarFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
