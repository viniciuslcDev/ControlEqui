package controlequi.com.br.controlequi.Service;

import controlequi.com.br.controlequi.Model.EmprestimoModel;
import controlequi.com.br.controlequi.Repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository){
        this.emprestimoRepository = emprestimoRepository;
    }

    public List<EmprestimoModel> listarEmprestimo() {
        return emprestimoRepository.findAll();
    }

    public EmprestimoModel salvarEmprestimo(EmprestimoModel emprestimo) {
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
