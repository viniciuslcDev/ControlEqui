package controlequi.com.br.controlequi.dto;



public class TecnicoDto {

    private Long idTecnico;
    private Long idFuncionario;

    // Construtor vazio (necessário para o Spring)
    public TecnicoDto() {
    }

    // Construtor cheio (opcional, mas pode ajudar)
    public TecnicoDto(Long idTecnico, Long idFuncionario) {
        this.idTecnico = idTecnico;
        this.idFuncionario = idFuncionario;
    }

    // Getters e Setters
    public Long getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Long idTecnico) {
        this.idTecnico = idTecnico;
    }

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}





