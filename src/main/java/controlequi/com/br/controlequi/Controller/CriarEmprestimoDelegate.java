package controlequi.com.br.controlequi.Controller;

import controlequi.com.br.controlequi.Model.EquipamentoModel;
import controlequi.com.br.controlequi.Model.PedidoModel;
import controlequi.com.br.controlequi.Repository.PedidoRepository;
import controlequi.com.br.controlequi.Service.EmprestimoService;
import controlequi.com.br.controlequi.Service.EquipamentoService;
import controlequi.com.br.controlequi.dto.EmprestimoDto;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


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

        equipamentoModel.setTipoEquipamento(pedidoModel.getTipoEquipamento());

        equipamentoModel.setStatusEquipamento(true);
        equipamentoModel.setDataAquisicao(LocalDate.now());


        EquipamentoModel equipamento = equipamentoService.salvarEquipamento(equipamentoModel);
        if (equipamento != null) {

            pedidoRepository.save(pedidoModel);
            EmprestimoDto emprestimoDto = new EmprestimoDto();

            emprestimoDto.setIdFuncionario(pedidoModel.getFuncionario().getIdFuncionario());
            emprestimoDto.setIdTecnico(pedidoModel.getTecnico().getIdFuncionario());
            emprestimoDto.setDataDevolucao(LocalDate.now().plusMonths(3));
            emprestimoDto.setDataEmprestimo(LocalDate.now());
            emprestimoDto.setIdEquipamento(equipamento.getIdEquipamento());
            emprestimoService.salvarEmprestimo(emprestimoDto);
        }

    }


}
