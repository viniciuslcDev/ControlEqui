package controlequi.com.br.controlequi.Controller;

import controlequi.com.br.controlequi.Model.PedidoModel;
import controlequi.com.br.controlequi.Service.PedidoService;
import controlequi.com.br.controlequi.dto.PedidoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@Tag(name = "Pedido", description = "Endpoints para gerenciamento de pedidos")
public class PedidoController {

   private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }


    @PostMapping
    @Operation(summary = "Cria um novo pedido")
    public PedidoModel criarPedido(@RequestBody PedidoDto pedido) {
        return pedidoService.salvarPedido(pedido);
    }

    @GetMapping
    @Operation(summary = "Lista todos os pedidos")
    public List<PedidoModel> listarPedidos() {
        return pedidoService.listarPedido();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um pedido existente")
    public PedidoModel atualizarPedido(@PathVariable Long id, @RequestBody PedidoDto pedidoAtualizado) {
        pedidoAtualizado.setIdPedido(id);
        return pedidoService.atualiza(pedidoAtualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um pedido pelo ID")
    public void deletarPedido(@PathVariable Long id) {
        pedidoService.deletar(id);
    }


}



