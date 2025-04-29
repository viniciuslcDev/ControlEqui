package controlequi.com.br.controlequi.dto;

import controlequi.com.br.controlequi.Model.EmprestimoModel;
import controlequi.com.br.controlequi.Model.EquipamentoModel;
import controlequi.com.br.controlequi.Model.FuncionarioModel;
import controlequi.com.br.controlequi.Model.TecnicoModel;
import controlequi.com.br.controlequi.StatusPedido;

import java.time.LocalDate;

public class PedidoDto {
    private Long idPedido;

    private Long funcionario;
    private Long tecnico;
    private LocalDate dataSolicitacao;
    private String tipoEquipamento;
    private StatusPedido statusPedido;

    public PedidoDto(Long idPedido, Long funcionario, Long tecnico, LocalDate dataSolicitacao, String tipoEquipamento, StatusPedido statusPedido) {
        this.idPedido = idPedido;
        this.funcionario = funcionario;
        this.tecnico = tecnico;
        this.dataSolicitacao = dataSolicitacao;
        this.tipoEquipamento = tipoEquipamento;
        this.statusPedido = statusPedido;
    }

    public PedidoDto(){}

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioModel funcionario) {
        this.funcionario = funcionario.getIdFuncionario();
    }

    public Long getTecnico() {
        return tecnico;
    }

    public void setTecnico(Long tecnico) {
        this.tecnico = tecnico;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }
}
