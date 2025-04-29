package controlequi.com.br.controlequi.Controller;

import controlequi.com.br.controlequi.Model.EmprestimoModel;
import controlequi.com.br.controlequi.Service.EmprestimoService;
import controlequi.com.br.controlequi.dto.EmprestimoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
@Tag(name = "Emprestimo", description = "Endpoints relacionados aos empréstimos de equipamentos")
public class EmprestimoController {
    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @GetMapping
    @Operation(summary = "Lista todos os empréstimos")
    public List<EmprestimoModel> listarEmprestimo() {
        return  emprestimoService.listarEmprestimo();
    }

    @GetMapping("/equipamento/{idEquipamento}")
    @Operation(summary = "Lista empréstimos por equipamento")
    public List<EmprestimoModel> listarEmprestimosPorEquipamento(@PathVariable Long idEquipamento) {
        return emprestimoService.buscarPorIdEquipamento(idEquipamento);
    }


    @PostMapping
    @Operation(summary = "Cadastra um novo empréstimo")
    public EmprestimoModel salvarEmprestimo(@RequestBody EmprestimoDto emprestimo) {
        return emprestimoService.salvarEmprestimo(emprestimo);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um empréstimo por ID")
    public ResponseEntity<EmprestimoModel> buscarPorId(Long id) {
        return emprestimoService.buscarEsprestimoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um empréstimo")
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
    @Operation(summary = "Exclui um empréstimo")
    public ResponseEntity<Void> deletarEmprestimo(@PathVariable Long id) {
        emprestimoService.deletarEmprestimo(id);
        return ResponseEntity.noContent().build();
    }




}
