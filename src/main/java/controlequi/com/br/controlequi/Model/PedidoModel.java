package controlequi.com.br.controlequi.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pedido")
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    private int qtdEquipamento;

    @ManyToOne
    @JoinColumn(name = "idFuncionario")
    private FuncionarioModel funcionario;

    @ManyToOne
    @JoinColumn(name = "idTecnico")
    private TecnicoModel tecnico;

    private LocalDate dataSolicitacao;
    private String tipoEquipamento;
    private String statusPedido;

    @ManyToOne
    @JoinColumn(name = "idEmprestimo")
    private EmprestimoModel emprestimo;

    private LocalDate dataDevolucao;
    private LocalDate dataEmprestimo;

    @ManyToOne
    @JoinColumn(name = "idEquipamento")
    private EquipamentoModel equipamento;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public int getQtdEquipamento() {
        return qtdEquipamento;
    }

    public void setQtdEquipamento(int qtdEquipamento) {
        this.qtdEquipamento = qtdEquipamento;
    }

    public FuncionarioModel getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioModel funcionario) {
        this.funcionario = funcionario;
    }

    public TecnicoModel getTecnico() {
        return tecnico;
    }

    public void setTecnico(TecnicoModel tecnico) {
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

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public EmprestimoModel getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(EmprestimoModel emprestimo) {
        this.emprestimo = emprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public EquipamentoModel getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(EquipamentoModel equipamento) {
        this.equipamento = equipamento;
    }

    // getters e setters
}
