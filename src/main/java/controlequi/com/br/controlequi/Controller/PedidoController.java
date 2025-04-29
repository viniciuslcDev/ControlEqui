package controlequi.com.br.controlequi.Controller;

import controlequi.com.br.controlequi.Model.PedidoModel;
import controlequi.com.br.controlequi.Repository.PedidoRepository;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pedido")
@Tag(name = "Pedido", description = "Endpoints para gerenciamento de pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private RuntimeService runtimeService;

    @PostMapping
    @Operation(summary = "Cria um novo pedido")
    public PedidoModel criarPedido(@RequestBody PedidoModel pedido) {
        return pedidoRepository.save(pedido);
    }

    @GetMapping
    @Operation(summary = "Lista todos os pedidos")
    public List<PedidoModel> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um pedido existente")
    public PedidoModel atualizarPedido(@PathVariable Long id, @RequestBody PedidoModel pedidoAtualizado) {
        pedidoAtualizado.setIdPedido(id);
        startProcess(id);
        return pedidoRepository.save(pedidoAtualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um pedido pelo ID")
    public void deletarPedido(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
    }

    private void startProcess(Long idPedido) {
        ProcessInstance processInstance = runtimeService.createProcessInstanceByKey("my-project-process")
                .setVariable("idPedido", idPedido)
                .execute();
    }

}



