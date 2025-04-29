package controlequi.com.br.controlequi.Controller;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TesteControl {

    @Autowired
    private RuntimeService runtimeService;

    @GetMapping("/start-process")
    public ResponseEntity<?> startProcess(
            @RequestParam(required = false) String idEmprestimo,
            @RequestParam(required = false) String data_emprestimo,
            @RequestParam(required = false) String data_devolucao,
            @RequestParam(required = false) String id_equipamento,
            @RequestParam(required = false) String id_funcionario,
            @RequestParam(required = false) String id_tecnico,
            @RequestParam(required = false) Map<String, Object> variables
    ) {
        try {
            // Se não houver variáveis, cria um mapa vazio
            if (variables == null) {
                variables = new HashMap<>();
            }

            // Inicia o processo com businessKey e variáveis
            ProcessInstance processInstance = runtimeService.createProcessInstanceByKey("my-project-process")
                    .businessKey(idEmprestimo)
                    .setVariable("idEmprestimo", idEmprestimo)
                    .setVariable("dataEmprestimo", data_emprestimo)
                    .setVariable("dataDevolucao", data_devolucao)
                    .setVariable("idEquipamento", id_equipamento)
                    .setVariable("idFuncionario", id_funcionario)
                    .setVariable("idTecnico", id_tecnico)

                    .setVariables(variables)
                    .execute();

            // Cria objeto de resposta
            Map<String, Object> response = new HashMap<>();
            response.put("mensagem", "Processo iniciado com sucesso");
            response.put("processInstanceId", processInstance.getId());
            response.put("businessKey", processInstance.getBusinessKey());
            response.put("processDefinitionId", processInstance.getProcessDefinitionId());

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            Map<String, String> erro = new HashMap<>();
            erro.put("erro", "Erro ao iniciar o processo: " + e.getMessage());
            return ResponseEntity.badRequest().body(erro);
        }
    }



}