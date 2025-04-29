package controlequi.com.br.controlequi.dto;

import controlequi.com.br.controlequi.StatusUsuario;

public class FuncionarioDto {
    private Long idFuncionario;
    private String nomeFuncionario;
    private String cpfFuncionario;
    private String cargoArea;
    private StatusUsuario statusEmpregaticio;
    private Boolean isTecnico;
    private String emailFuncionario;
    private StatusUsuario statusUsuario;

    public FuncionarioDto(Long idFuncionario, String nomeFuncionario, String cpfFuncionario, String cargoArea, StatusUsuario statusEmpregaticio, Boolean isTecnico, String emailFuncionario, StatusUsuario statusUsuario) {
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.cpfFuncionario = cpfFuncionario;
        this.cargoArea = cargoArea;
        this.statusEmpregaticio = statusEmpregaticio;
        this.isTecnico = isTecnico;
        this.emailFuncionario = emailFuncionario;
        this.statusUsuario = statusUsuario;
    }

    public FuncionarioDto() {
    }

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

    public StatusUsuario getStatusEmpregaticio() {
        return statusEmpregaticio;
    }

    public void setStatusEmpregaticio(StatusUsuario statusEmpregaticio) {
        this.statusEmpregaticio = statusEmpregaticio;
    }

    public Boolean getTecnico() {
        return isTecnico;
    }

    public void setTecnico(Boolean tecnico) {
        isTecnico = tecnico;
    }

    public String getEmailFuncionario() {
        return emailFuncionario;
    }

    public void setEmailFuncionario(String emailFuncionario) {
        this.emailFuncionario = emailFuncionario;
    }

    public StatusUsuario getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(StatusUsuario statusUsuario) {
        this.statusUsuario = statusUsuario;
    }
}
