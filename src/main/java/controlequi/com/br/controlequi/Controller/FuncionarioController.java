package controlequi.com.br.controlequi.Controller;

import controlequi.com.br.controlequi.Model.FuncionarioModel;
import controlequi.com.br.controlequi.Service.FuncionarioService;
import controlequi.com.br.controlequi.dto.FuncionarioDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios") // URL base para a API
@Tag(name = "Funcionario", description = "Endpoints para gerenciamento de funcionários")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    // Cadastrar novo funcionário
    @PostMapping
    @Operation(summary = "Cadastra um novo funcionário")
    public ResponseEntity<FuncionarioDto> criarFuncionario(@RequestBody FuncionarioDto funcionario) {
        FuncionarioModel funcionarioModel = funcionarioService.salvarFuncionario(funcionario);

        // Converte o Model de volta para o DTO para retornar para o front-end
        FuncionarioDto respostaDto = new FuncionarioDto(
                funcionarioModel.getIdFuncionario(),
                funcionarioModel.getNomeFuncionario(),
                funcionarioModel.getCpfFuncionario(),
                funcionarioModel.getCargoArea(),
                funcionarioModel.getStatusEmpregaticio(),
                funcionarioModel.getTecnico(),
                funcionarioModel.getEmailFuncionario(),
                funcionarioModel.getStatusUsuario()
        );

        return ResponseEntity.ok(respostaDto);
    }


    // Listar todos os funcionários
    @GetMapping
    @Operation(summary = "Lista todos os funcionários")
    public ResponseEntity<List<FuncionarioModel>> listarFuncionarios() {
        List<FuncionarioModel> funcionarios = funcionarioService.listarFuncionarios();
        return ResponseEntity.ok(funcionarios);
    }

    // Buscar funcionário por ID
    @GetMapping("/{id}")
    @Operation(summary = "Busca um funcionário por ID")
    public ResponseEntity<FuncionarioModel> buscarFuncionarioPorId(@PathVariable Long id) {
        Optional<FuncionarioModel> funcionario = funcionarioService.buscarFuncionarioPorId(id);

        return funcionario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualizar funcionário
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza os dados de um funcionário")
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
    @Operation(summary = "Deleta um funcionário")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
        funcionarioService.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status/{status}")
    @Operation(summary = "Busca funcionários pelo status de usuário")
    public ResponseEntity<?> buscarPorStatus(@PathVariable String status) {
        List<FuncionarioModel> funcionario = funcionarioService.buscarPorStatusUsuario(status);
        return ResponseEntity.ok(funcionario);
    }
}
