package controlequi.com.br.controlequi.Controller;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class AutomatizacaoEmprestimo implements JavaDelegate {
    private Logger logger = LoggerFactory.getLogger(AutomatizacaoEmprestimo.class);

    @Override
    public void execute(DelegateExecution delegateExecution) {
        logger.info("Verificação realizada!");
    }
}
