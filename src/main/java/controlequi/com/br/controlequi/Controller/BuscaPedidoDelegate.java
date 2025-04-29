package controlequi.com.br.controlequi.Controller;

import controlequi.com.br.controlequi.Model.PedidoModel;
import controlequi.com.br.controlequi.Repository.PedidoRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BuscaPedidoDelegate implements JavaDelegate {
    private PedidoRepository pedidoRepository;
    private Logger logger = LoggerFactory.getLogger(BuscaPedidoDelegate.class);


    public BuscaPedidoDelegate(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        Long idPedido = Long.valueOf(String.valueOf(execution.getVariable("idPedido")));
        Optional<PedidoModel> pedidoModel = pedidoRepository.findById(idPedido);
        if (pedidoModel.isPresent()) {
            PedidoModel pedido = pedidoModel.get();
            logger.info("Pedido encontrado: " + idPedido);
            execution.setVariable("status",pedido.getStatusPedido().name());
        } else {
            logger.error("Pedido não encontrado com ID: " + idPedido);
            throw new Exception("Pedido não encontrado");

        }

    }


}
