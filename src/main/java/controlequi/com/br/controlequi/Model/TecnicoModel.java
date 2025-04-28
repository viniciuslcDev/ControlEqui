package controlequi.com.br.controlequi.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "tecnico")
public class TecnicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_Funcionario", referencedColumnName = "id_Funcionario")
    private FuncionarioModel funcionario;

    public  TecnicoModel(){}

    public FuncionarioModel getFuncionario() {
        return funcionario;
    }


}
