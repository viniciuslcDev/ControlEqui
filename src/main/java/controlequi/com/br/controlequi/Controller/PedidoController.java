package controlequi.com.br.controlequi.Controller;

import controlequi.com.br.controlequi.Model.PedidoModel;
import controlequi.com.br.controlequi.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    public PedidoModel criarPedido(@RequestBody PedidoModel pedido) {
        return pedidoRepository.save(pedido);
    }

    @GetMapping
    public List<PedidoModel> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @PutMapping("/{id}")
    public PedidoModel atualizarPedido(@PathVariable Long id, @RequestBody PedidoModel pedidoAtualizado) {
        pedidoAtualizado.setIdPedido(id);
        return pedidoRepository.save(pedidoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarPedido(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
    }
}
