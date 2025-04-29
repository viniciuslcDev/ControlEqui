package controlequi.com.br.controlequi.Controller;

import controlequi.com.br.controlequi.Model.EmprestimoModel;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class AutomatizacaoEmprestimo implements JavaDelegate {

    private final EmprestimoModel emprestimoModel;

    public AutomatizacaoEmprestimo(EmprestimoModel emprestimoModel) {
        this.emprestimoModel = emprestimoModel;
    }



    @Override
    public void execute(DelegateExecution delegateExecution) { }
}
