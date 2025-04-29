package controlequi.com.br.controlequi.Controller;

import controlequi.com.br.controlequi.Model.PedidoModel;
import controlequi.com.br.controlequi.Repository.PedidoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@Tag(name = "Pedido", description = "Endpoints para gerenciamento de pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

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
        return pedidoRepository.save(pedidoAtualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um pedido pelo ID")
    public void deletarPedido(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
    }
}
