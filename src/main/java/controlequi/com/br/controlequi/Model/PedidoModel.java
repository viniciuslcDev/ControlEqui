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


    // getters e setters
}
