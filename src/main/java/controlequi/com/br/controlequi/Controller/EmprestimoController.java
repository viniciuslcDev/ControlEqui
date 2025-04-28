package controlequi.com.br.controlequi.Controller;

import controlequi.com.br.controlequi.Model.EmprestimoModel;
import controlequi.com.br.controlequi.Service.EmprestimoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {
    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @GetMapping
    public List<EmprestimoModel> listarEmprestimo() {
        return  emprestimoService.listarEmprestimo();
    }

    @PostMapping
    public EmprestimoModel salvarEmprestimo(@RequestBody EmprestimoModel emprestimo) {
        return emprestimoService.salvarEmprestimo(emprestimo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoModel> buscarPorId(Long id) {
        return emprestimoService.buscarEsprestimoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmprestimoModel> atualizarFuncionario(@PathVariable Long id,
                                                                 @RequestBody EmprestimoModel emprestimoAtualizado) {
        EmprestimoModel funcionario = emprestimoService.atualizarEmprestimo(id, emprestimoAtualizado);

        if (funcionario != null) {
            return ResponseEntity.ok(funcionario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmprestimo(@PathVariable Long id) {
        emprestimoService.deletarEmprestimo(id);
        return ResponseEntity.noContent().build();
    }




}
