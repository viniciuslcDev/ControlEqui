package controlequi.com.br.controlequi.Controller;

import controlequi.com.br.controlequi.Model.EquipamentoModel;
import controlequi.com.br.controlequi.Service.EquipamentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/equipamentos")
@Tag(name = "Equipamento")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    // Método para listar todos os equipamentos
    @GetMapping
    public ResponseEntity<List<EquipamentoModel>> listarEquipamentos() {
        List<EquipamentoModel> equipamentos = equipamentoService.listarEquipamentos();
        if (equipamentos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Caso não tenha equipamentos
        }
        return new ResponseEntity<>(equipamentos, HttpStatus.OK);
    }

    // Método para buscar equipamento por ID
    @GetMapping("/{id}")
    public ResponseEntity<EquipamentoModel> buscarEquipamentoPorId(@PathVariable Long id) {
        Optional<EquipamentoModel> equipamento = equipamentoService.buscarEquipamentoPorId(id);
        if (equipamento.isPresent()) {
            return new ResponseEntity<>(equipamento.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Se não encontrar o equipamento
    }

    // Método para buscar equipamento por serial number
    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<EquipamentoModel> buscarEquipamentoPorSerial(@PathVariable Long serialNumber) {
        Optional<EquipamentoModel> equipamento = equipamentoService.buscarEquipamentoPorSerialNumber(Math.toIntExact(serialNumber));
        if (equipamento.isPresent()) {
            return new ResponseEntity<>(equipamento.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Se não encontrar o equipamento
    }

    // Método para adicionar um novo equipamento
    @PostMapping
    public ResponseEntity<EquipamentoModel> adicionarEquipamento(@RequestBody EquipamentoModel equipamento) {
        EquipamentoModel novoEquipamento = equipamentoService.salvarEquipamento(equipamento);
        return new ResponseEntity<>(novoEquipamento, HttpStatus.CREATED);
    }

    // Método para atualizar um equipamento
    @PutMapping("/{id}")
    public ResponseEntity<EquipamentoModel> atualizarEquipamento(@PathVariable Long id,@RequestBody EquipamentoModel equipamento) {
        Optional<EquipamentoModel> equipamentoExistente = equipamentoService.buscarEquipamentoPorId(id);
        if (equipamentoExistente.isPresent()) {
            equipamento.setIdEquipamento(id); // Atualiza o ID do equipamento
            EquipamentoModel equipamentoAtualizado = equipamentoService.salvarEquipamento(equipamento);
            return new ResponseEntity<>(equipamentoAtualizado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Se o equipamento não for encontrado
    }

    // Método para deletar um equipamento
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarEquipamento(@PathVariable Long id) {
        Optional<EquipamentoModel> equipamentoExistente = equipamentoService.buscarEquipamentoPorId(id);
        if (equipamentoExistente.isPresent()) {
            equipamentoService.deletarEquipamento(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Se o equipamento não for encontrado
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<?> buscarPorStatus(@PathVariable String status) {
        List<EquipamentoModel> equipamento = equipamentoService.buscarPorStatus(status);
        return ResponseEntity.ok(equipamento);
    }

}
