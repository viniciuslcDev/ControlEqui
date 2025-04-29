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
    private final EquipamentoRepository equipamentoRepository;
    private final TecnicoRepository tecnicoRepository;
    private final FuncionarioRepository funcionarioRepository;


    public EmprestimoService(EmprestimoRepository emprestimoRepository, EquipamentoRepository equipamentoRepository, TecnicoRepository tecnicoRepository, FuncionarioRepository funcionarioRepository){
        this.emprestimoRepository = emprestimoRepository;
        this.equipamentoRepository = equipamentoRepository;
        this.tecnicoRepository = tecnicoRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<EmprestimoModel> listarEmprestimo() {
        return emprestimoRepository.findAll();
    }

    public EmprestimoModel salvarEmprestimo(EmprestimoDto emprestimoDto) {
        // Buscar Técnico pelo ID

        FuncionarioModel tecnico = funcionarioRepository.findById(emprestimoDto.getIdTecnico())
                .orElseThrow(() -> new RuntimeException("Técnico não encontrado com ID: " + emprestimoDto.getIdTecnico()));

        // Buscar Equipamento pelo ID
        EquipamentoModel equipamento = equipamentoRepository.findById(emprestimoDto.getIdEquipamento())
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado com ID: " + emprestimoDto.getIdEquipamento()));

        // Criar o modelo de Emprestimo
        EmprestimoModel emprestimoModel = new EmprestimoModel();
        emprestimoModel.setDataEmprestimo(emprestimoDto.getDataEmprestimo());
        emprestimoModel.setEquipamento(equipamento);
        emprestimoModel.setTecnico(tecnico); // Aqui você deve passar o técnico encontrado

        // Salvar o Emprestimo no banco
        return emprestimoRepository.save(emprestimoModel);

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
