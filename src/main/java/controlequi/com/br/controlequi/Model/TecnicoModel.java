package controlequi.com.br.controlequi.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "tecnico")
public class TecnicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTecnico;

    @OneToOne
    @JoinColumn(name = "idFuncionario", referencedColumnName = "idFuncionario")
    private FuncionarioModel funcionario;

    public  TecnicoModel(){}

    public Long getIdTecnico() {
        return idTecnico;
    }

    public FuncionarioModel getFuncionario() {
        return funcionario;
    }


}
