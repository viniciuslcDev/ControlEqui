package controlequi.com.br.controlequi.Model;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "emprestimo")
public class EmprestimoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprestimo;

    @ManyToOne
    @JoinColumn(name = "idFuncionario", referencedColumnName = "idFuncionario")
    private FuncionarioModel funcionario;

    @ManyToOne
    @JoinColumn(name = "idTecnico", referencedColumnName = "idTecnico")
    private TecnicoModel tecnico;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataEmprestimo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDevolucao;

    @ManyToOne
    @JoinColumn(name = "idEquipamento", referencedColumnName = "idEquipamento")
    private EquipamentoModel equipamento;

    public EmprestimoModel(){}


    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
