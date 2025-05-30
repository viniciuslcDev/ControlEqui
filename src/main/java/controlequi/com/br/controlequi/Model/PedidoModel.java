package controlequi.com.br.controlequi.Model;

import controlequi.com.br.controlequi.StatusPedido;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pedido")
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;


    @ManyToOne
    @JoinColumn(name = "idFuncionario")
    private FuncionarioModel funcionario;

    @ManyToOne
    @JoinColumn(name = "idTecnico")
    private FuncionarioModel tecnico;

    private LocalDate dataSolicitacao;
    private String tipoEquipamento;
    private StatusPedido statusPedido;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }


    public FuncionarioModel getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioModel funcionario) {
        this.funcionario = funcionario;
    }

    public FuncionarioModel getTecnico() {
        return tecnico;
    }

    public void setTecnico(FuncionarioModel tecnico) {
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


    // getters e setters
}
