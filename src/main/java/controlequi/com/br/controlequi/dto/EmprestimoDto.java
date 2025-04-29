package controlequi.com.br.controlequi.dto;

import controlequi.com.br.controlequi.Model.EquipamentoModel;
import controlequi.com.br.controlequi.Model.FuncionarioModel;
import controlequi.com.br.controlequi.Model.TecnicoModel;

import java.time.LocalDate;

public class EmprestimoDto {
    private Long idEmprestimo;
    private Long idFuncionario;
    private Long idTecnico;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private Long idEquipamento;


    public EmprestimoDto(Long idEmprestimo, Long idFuncionario, Long idTecnico, LocalDate dataEmprestimo, LocalDate dataDevolucao, Long idEquipamento) {
        this.idEmprestimo = idEmprestimo;
        this.idFuncionario = idFuncionario;
        this.idTecnico = idTecnico;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.idEquipamento = idEquipamento;
    }

    public EmprestimoDto() {   }

    public Long getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Long idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Long getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Long idTecnico) {
        this.idTecnico = idTecnico;
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

    public Long getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(Long idEquipamento) {
        this.idEquipamento = idEquipamento;
    }
}
