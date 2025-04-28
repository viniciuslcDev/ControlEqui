package controlequi.com.br.controlequi.Model;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "emprestimo")
public class EmprestimoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinColumn(name = "id_Funcionario", referencedColumnName = "id_Funcionario")
    private FuncionarioModel funcionario;

    @ManyToOne
    @JoinColumn(name = "id_Tecnico", referencedColumnName = "id_Tecnico")
    private TecnicoModel tecnico;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_emprestimo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_devolucao;

    @ManyToOne
    @JoinColumn(name = "id_Equipamento", referencedColumnName = "id_Equipamento")
    private Long equipamento;

    public EmprestimoModel(){}


    public LocalDate getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(LocalDate data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public LocalDate getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(LocalDate data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
}
