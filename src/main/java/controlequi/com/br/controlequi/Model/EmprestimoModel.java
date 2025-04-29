package controlequi.com.br.controlequi.Model;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "emprestimoequi")
public class EmprestimoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprestimo;

    @ManyToOne
    @JoinColumn(name = "idFuncionario", referencedColumnName = "idFuncionario")
    private FuncionarioModel funcionario;

    @ManyToOne
    @JoinColumn(name = "idTecnico", referencedColumnName = "idFuncionario")
    private FuncionarioModel tecnico;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataEmprestimo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDevolucao;

    @ManyToOne
    @JoinColumn(name = "idEquipamento", referencedColumnName = "idEquipamento")
    private EquipamentoModel equipamento;

    public EmprestimoModel(){}

    public void setIdEmprestimo(Long idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public void setFuncionario(FuncionarioModel funcionario) {
        this.funcionario = funcionario;
    }

    public void setTecnico(FuncionarioModel tecnico) {
        this.tecnico = tecnico;
    }

    public void setEquipamento(EquipamentoModel equipamento) {
        this.equipamento = equipamento;
    }

    public Long getIdEmprestimo() {
        return idEmprestimo;
    }

    public FuncionarioModel getFuncionario() {
        return funcionario;
    }

    public FuncionarioModel getTecnico() {
        return tecnico;
    }

    public EquipamentoModel getEquipamento() {
        return equipamento;
    }

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
