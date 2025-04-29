package controlequi.com.br.controlequi.Service;

import controlequi.com.br.controlequi.Model.FuncionarioModel;
import controlequi.com.br.controlequi.Repository.FuncionarioRepository;
import controlequi.com.br.controlequi.StatusUsuario;
import controlequi.com.br.controlequi.dto.FuncionarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // Cadastrar um novo funcionário
    public FuncionarioModel salvarFuncionario(FuncionarioDto dto) {
        FuncionarioModel model = new FuncionarioModel();
        model.setNomeFuncionario(dto.getNomeFuncionario());
        model.setCpfFuncionario(dto.getCpfFuncionario());
        model.setCargoArea(dto.getCargoArea());
        model.setStatusEmpregaticio(dto.getStatusEmpregaticio());
        model.setEmailFuncionario(dto.getEmailFuncionario());
        model.setIsTecnico(dto.getTecnico());
        model.setStatusUsuario(dto.getStatusUsuario());

        return funcionarioRepository.save(model);
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
            funcionario.setIsTecnico(funcionarioAtualizado.getisTecnico());
            funcionario.setEmailFuncionario(funcionarioAtualizado.getEmailFuncionario());
            return funcionarioRepository.save(funcionario);
        } else {
            return null; // ou lançar exceção personalizada
        }
    }

    // Deletar um funcionário
    public void deletarFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }

    // Listar apenas os funcionários que são técnicos
    public List<FuncionarioModel> listarTecnicos() {
        return funcionarioRepository.findTecnicos();
    }

    public List<FuncionarioModel> buscarPorStatusUsuario(String status){
        StatusUsuario statusUsuario = StatusUsuario.valueOf(status.toUpperCase());
        return funcionarioRepository.findByStatusUsuario(statusUsuario);
    }
}
