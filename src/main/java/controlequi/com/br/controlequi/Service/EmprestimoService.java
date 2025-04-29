package controlequi.com.br.controlequi.Service;

import controlequi.com.br.controlequi.Model.EmprestimoModel;
import controlequi.com.br.controlequi.Model.EquipamentoModel;
import controlequi.com.br.controlequi.Model.FuncionarioModel;
import controlequi.com.br.controlequi.Model.TecnicoModel;
import controlequi.com.br.controlequi.Repository.EmprestimoRepository;
import controlequi.com.br.controlequi.Repository.EquipamentoRepository;
import controlequi.com.br.controlequi.Repository.FuncionarioRepository;
import controlequi.com.br.controlequi.Repository.TecnicoRepository;
import controlequi.com.br.controlequi.dto.EmprestimoDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final FuncionarioRepository funcionarioRepository;

    private final TecnicoRepository tecnicoRepository;
    private final EquipamentoRepository equipamentoRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository,
                             FuncionarioRepository funcionarioRepository, TecnicoRepository tecnicoRepository,
                             EquipamentoRepository equipamentoRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.funcionarioRepository = funcionarioRepository;

        this.tecnicoRepository = tecnicoRepository;
        this.equipamentoRepository = equipamentoRepository;
    }

    public List<EmprestimoModel> listarEmprestimo() {
        return emprestimoRepository.findAll();
    }

    public EmprestimoModel salvarEmprestimo(EmprestimoDto dto) {
        FuncionarioModel funcionario = funcionarioRepository.findById(dto.getIdFuncionario())
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));

        TecnicoModel tecnico = tecnicoRepository.findById(dto.getIdTecnico())
                .orElseThrow(() -> new RuntimeException("Tecnico não encontrado"));

        EquipamentoModel equipamento = equipamentoRepository.findById(dto.getIdEquipamento())
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        EmprestimoModel emprestimo = new EmprestimoModel();
        emprestimo.setIdEmprestimo(dto.getIdEmprestimo());
        emprestimo.setFuncionario(funcionario);
        emprestimo.setTecnico(tecnico);
        emprestimo.setDataEmprestimo(dto.getDataEmprestimo());
        emprestimo.setDataDevolucao(dto.getDataDevolucao());
        emprestimo.setEquipamento(equipamento);

        return emprestimoRepository.save(emprestimo);
    }

    public Optional<EmprestimoModel> buscarEsprestimoPorId(Long id) {
        return emprestimoRepository.findById(id);
    }

    public  EmprestimoModel atualizarEmprestimo(Long id, EmprestimoModel emprestimoAtualizado) {
        Optional<EmprestimoModel> emprestimoExistente = emprestimoRepository.findById(id);

        if (emprestimoExistente.isPresent()) {
            EmprestimoModel emprestimo = emprestimoExistente.get();
            emprestimo.setDataEmprestimo(emprestimoAtualizado.getDataEmprestimo());
            emprestimo.setDataDevolucao(emprestimoAtualizado.getDataDevolucao());

            return emprestimoRepository.save(emprestimo);
        } else {
            return null;
        }
    }

    public void deletarEmprestimo(Long id) {
        emprestimoRepository.deleteById(id);
    }
}
