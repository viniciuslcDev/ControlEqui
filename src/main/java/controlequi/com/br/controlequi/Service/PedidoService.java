package controlequi.com.br.controlequi.Service;

import controlequi.com.br.controlequi.Model.FuncionarioModel;
import controlequi.com.br.controlequi.Model.PedidoModel;
import controlequi.com.br.controlequi.Repository.PedidoRepository;
import controlequi.com.br.controlequi.dto.PedidoDto;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final FuncionarioService funcionarioService;
    private final RuntimeService runtimeService;

    public PedidoService(PedidoRepository pedidoRepository, FuncionarioService funcionarioService, RuntimeService runtimeService) {
        this.pedidoRepository = pedidoRepository;
        this.funcionarioService = funcionarioService;
        this.runtimeService = runtimeService;
    }

    public List<PedidoModel> listarPedido(){
        return pedidoRepository.findAll();
    }

    public Optional<PedidoModel> listarPorId(Long id){
        return pedidoRepository.findById(id);
    }

    public PedidoModel salvarPedido(PedidoDto dto){
        FuncionarioModel funcionarioModel = funcionarioService.buscarFuncionarioPorId(dto.getFuncionario()).orElseThrow(() -> new RuntimeException("Técnico não encontrado com ID: " + dto.getFuncionario()));;
        FuncionarioModel tecnico = funcionarioService.buscarFuncionarioPorId(dto.getTecnico()).orElseThrow(() -> new RuntimeException("Técnico não encontrado com ID: " + dto.getFuncionario()));;
        PedidoModel model = new PedidoModel();
        model.setStatusPedido(dto.getStatusPedido());
        model.setFuncionario(funcionarioModel);
        model.setTecnico(tecnico);
        model.setDataSolicitacao(dto.getDataSolicitacao());
        model.setTipoEquipamento(dto.getTipoEquipamento());

        PedidoModel save = pedidoRepository.save(model);
        startProcess(save.getIdPedido());
        return save;


    }

    public PedidoModel atualiza(PedidoDto dto){
        FuncionarioModel funcionarioModel = funcionarioService.buscarFuncionarioPorId(dto.getFuncionario()).orElseThrow(() -> new RuntimeException("Técnico não encontrado com ID: " + dto.getFuncionario()));;
        FuncionarioModel tecnico = funcionarioService.buscarFuncionarioPorId(dto.getTecnico()).orElseThrow(() -> new RuntimeException("Técnico não encontrado com ID: " + dto.getFuncionario()));;
        PedidoModel model = new PedidoModel();
        model.setIdPedido(dto.getIdPedido());
        model.setStatusPedido(dto.getStatusPedido());
        model.setFuncionario(funcionarioModel);
        model.setTecnico(tecnico);
        model.setDataSolicitacao(dto.getDataSolicitacao());
        model.setTipoEquipamento(dto.getTipoEquipamento());



        PedidoModel save = pedidoRepository.save(model);
        startProcess(save.getIdPedido());
        return save;

    }

    private void startProcess(Long idPedido) {
        try{
            ProcessInstance processInstance = runtimeService.createProcessInstanceByKey("my-project-process")
                    .setVariable("idPedido", idPedido)
                    .execute();
        }catch (Exception e){

        }
    }


    public void deletar(Long id){
        pedidoRepository.deleteById(id);
    }



}
