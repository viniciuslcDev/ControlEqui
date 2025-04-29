package controlequi.com.br.controlequi.Model;

import controlequi.com.br.controlequi.StatusEnum;
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



    @Column(name = "tipo_equipamento", nullable = false)
    private String tipoEquipamento;

    @Column(name = "status_equipamento", nullable = false)
    private boolean statusEquipamento; // true para "em uso" e false para "em estoque"

    @Column(name = "serial_number")
    private int serialNumber;  // Garantir que o SerialNumber seja único

    private StatusEnum status;

    // Getters e Setters


    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Long getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(Long idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }



    public String getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public boolean isStatusEquipamento() {
        return statusEquipamento;
    }

    public void setStatusEquipamento(boolean statusEquipamento) {
        this.statusEquipamento = statusEquipamento;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }
}
