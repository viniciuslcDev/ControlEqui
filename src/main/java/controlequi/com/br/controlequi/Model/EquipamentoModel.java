package controlequi.com.br.controlequi.Model;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "equipamentos")
public class EquipamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipamento;

    @Column(name = "data_aquisicao", nullable = false)
    private LocalDate dataAquisicao;

    @ManyToMany
    @JoinColumn(name = "id_Funcionario", referencedColumnName = "id_Funcionario", nullable = false)
    private FuncionarioModel funcionario;

    @Column(name = "tipo_equipamento", nullable = false)
    private String tipoEquipamento;

    @Column(name = "status_equipamento", nullable = false)
    private boolean statusEquipamento; // true para "em uso" e false para "em estoque"

    @Column(nullable = false)
    private int SerialNumber;

}