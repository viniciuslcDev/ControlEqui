package controlequi.com.br.controlequi.Service;

import controlequi.com.br.controlequi.Model.EmprestimoModel;
import controlequi.com.br.controlequi.Model.FuncionarioModel;
import controlequi.com.br.controlequi.Repository.EmprestimoRepository;
import controlequi.com.br.controlequi.Repository.FuncionarioRepository;
import controlequi.com.br.controlequi.StatusUsuario;
import controlequi.com.br.controlequi.dto.FuncionarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    // Cadastrar um novo funcionário
    public FuncionarioModel salvarFuncionario(FuncionarioDto dto) {
        FuncionarioModel model = new FuncionarioModel();
        model.setIdFuncionario(dto.getIdFuncionario());
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
            return null;
        }
    }

    // Deletar um funcionário (somente se não houver equipamentos ativos)
    public void deletarFuncionario(Long id) {
        // Verifica se ele é técnico com empréstimos ativos
        List<EmprestimoModel> comoTecnico = emprestimoRepository.findByTecnicoIdFuncionario(id);
        boolean temComoTecnico = comoTecnico.stream().anyMatch(e -> e.getDataDevolucao() == null);

        // Verifica se ele é dono de algum equipamento emprestado
        List<EmprestimoModel> comoDonoEquipamento = emprestimoRepository.findByEquipamentoFuncionarioIdFuncionario(id);
        boolean temComoDono = comoDonoEquipamento.stream().anyMatch(e -> e.getDataDevolucao() == null);

        if (temComoTecnico || temComoDono) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, // Ou BAD_REQUEST se preferir
                    "Funcionário não pode ser deletado pois possui empréstimos ativos."
            );
        }

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
