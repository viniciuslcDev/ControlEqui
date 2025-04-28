package controlequi.com.br.controlequi.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncionario;

    @Column(nullable = false)
    private String nomeFuncionario;

    @Column(unique = true, nullable = false, length = 11)
    private String cpfFuncionario;

    @Column(nullable = false)
    private String cargoArea;

    @Column(nullable = false)
    private String statusEmpregaticio;

    @Column(nullable = false)
    private Boolean isTecnico;

    // Novo campo adicionado:
    @Column(nullable = false, unique = true)
    private String emailFuncionario;

    // Construtor vazio
    public Funcionario() {
    }

    // Getters e Setters
    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getCargoArea() {
        return cargoArea;
    }

    public void setCargoArea(String cargoArea) {
        this.cargoArea = cargoArea;
    }

    public String getStatusEmpregaticio() {
        return statusEmpregaticio;
    }

    public void setStatusEmpregaticio(String statusEmpregaticio) {
        this.statusEmpregaticio = statusEmpregaticio;
    }

    public Boolean getIsTecnico() {
        return isTecnico;
    }

    public void setIsTecnico(Boolean isTecnico) {
        this.isTecnico = isTecnico;
    }

    public String getEmailFuncionario() {
        return emailFuncionario;
    }

    public void setEmailFuncionario(String emailFuncionario) {
        this.emailFuncionario = emailFuncionario;
    }
}
