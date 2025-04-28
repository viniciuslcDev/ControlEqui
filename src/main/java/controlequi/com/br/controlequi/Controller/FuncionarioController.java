package controlequi.com.br.controlequi.Controller;

import controlequi.com.br.controlequi.Model.FuncionarioModel;
import controlequi.com.br.controlequi.Service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios") // URL base para a API
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    // Cadastrar novo funcionário
    @PostMapping
    public ResponseEntity<FuncionarioModel> criarFuncionario(@RequestBody FuncionarioModel funcionario) {
        FuncionarioModel novoFuncionario = funcionarioService.salvarFuncionario(funcionario);
        return ResponseEntity.ok(novoFuncionario);
    }

    // Listar todos os funcionários
    @GetMapping
    public ResponseEntity<List<FuncionarioModel>> listarFuncionarios() {
        List<FuncionarioModel> funcionarios = funcionarioService.listarFuncionarios();
        return ResponseEntity.ok(funcionarios);
    }

    // Buscar funcionário por ID
    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioModel> buscarFuncionarioPorId(@PathVariable Long id) {
        Optional<FuncionarioModel> funcionario = funcionarioService.buscarFuncionarioPorId(id);

        return funcionario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualizar funcionário
    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioModel> atualizarFuncionario(@PathVariable Long id,
                                                                 @RequestBody FuncionarioModel funcionarioAtualizado) {
        FuncionarioModel funcionario = funcionarioService.atualizarFuncionario(id, funcionarioAtualizado);

        if (funcionario != null) {
            return ResponseEntity.ok(funcionario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar funcionário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
        funcionarioService.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }
}
