package controlequi.com.br.controlequi.Controller;

import controlequi.com.br.controlequi.Model.EmprestimoModel;
import controlequi.com.br.controlequi.Model.EquipamentoModel;
import controlequi.com.br.controlequi.Model.PedidoModel;
import controlequi.com.br.controlequi.Repository.EmprestimoRepository;
import controlequi.com.br.controlequi.Repository.EquipamentoRepository;
import controlequi.com.br.controlequi.Repository.PedidoRepository;
import controlequi.com.br.controlequi.Service.EmprestimoService;
import controlequi.com.br.controlequi.Service.EquipamentoService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;


@Component
public class CriarEmprestimoDelegate implements JavaDelegate {
    private Logger logger = LoggerFactory.getLogger(CriarEmprestimoDelegate.class);

    public CriarEmprestimoDelegate(EquipamentoService equipamentoService, EmprestimoService emprestimoService, PedidoRepository pedidoRepository) {
        this.equipamentoService = equipamentoService;
        this.emprestimoService = emprestimoService;
        this.pedidoRepository = pedidoRepository;
    }

    private EquipamentoService equipamentoService;
    private EmprestimoService emprestimoService;
    private PedidoRepository pedidoRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        logger.info("Verificação realizada!");

        Long idPedido = Long.valueOf(String.valueOf(delegateExecution.getVariable("idPedido")));
        PedidoModel pedidoModel = pedidoRepository.findById(idPedido).get();
        EquipamentoModel equipamentoModel = new EquipamentoModel();
        equipamentoModel.setFuncionario(pedidoModel.getFuncionario());
        equipamentoModel.setTipoEquipamento(pedidoModel.getTipoEquipamento());
        equipamentoModel.setSerialNumber(pedidoModel.getEquipamento().getSerialNumber());
        equipamentoModel.setStatusEquipamento(true);
        equipamentoModel.setDataAquisicao(LocalDate.now());


        EquipamentoModel equipamento = equipamentoService.salvarEquipamento(equipamentoModel);
        if (equipamento != null) {
            pedidoModel.setEquipamento(equipamento);
            pedidoRepository.save(pedidoModel);
            EmprestimoModel emprestimoModel = new EmprestimoModel();

            emprestimoModel.setFuncionario(pedidoModel.getFuncionario());
            emprestimoModel.setEquipamento(equipamento);
            emprestimoModel.setIdEmprestimo(equipamento.getIdEquipamento());
            emprestimoModel.setDataDevolucao(LocalDate.now().plusMonths(3));
            emprestimoModel.setDataEmprestimo(LocalDate.now());
            emprestimoService.salvarEmprestimo(emprestimoModel);
        }

    }

}
