package controlequi.com.br.controlequi.Service;

import controlequi.com.br.controlequi.Model.EquipamentoModel;
import controlequi.com.br.controlequi.Repository.EquipamentoRepository;
import controlequi.com.br.controlequi.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    // Salvar novo equipamento ou atualizar um equipamento existente
    public EquipamentoModel salvarEquipamento(EquipamentoModel equipamento) {
        return equipamentoRepository.save(equipamento);
    }

    // Listar todos os equipamentos
    public List<EquipamentoModel> listarEquipamentos() {
        return equipamentoRepository.findAll();
    }

    // Buscar equipamento por ID
    public Optional<EquipamentoModel> buscarEquipamentoPorId(Long idEquipamento) {
        return equipamentoRepository.findById(idEquipamento);
    }

    // Buscar equipamento por Serial Number
    public Optional<EquipamentoModel> buscarEquipamentoPorSerialNumber(int serialNumber) {
        return equipamentoRepository.findByserialNumber(serialNumber);
    }

    // Atualizar equipamento existente
    public EquipamentoModel atualizarEquipamento(Long idEquipamento, EquipamentoModel equipamentoAtualizado) {
        Optional<EquipamentoModel> equipamentoExistente = equipamentoRepository.findById(idEquipamento);

        if (equipamentoExistente.isPresent()) {
            EquipamentoModel equipamento = equipamentoExistente.get();

            // Atualiza os campos conforme necessário
            if (equipamentoAtualizado.getTipoEquipamento() != null) {
                equipamento.setTipoEquipamento(equipamentoAtualizado.getTipoEquipamento());
            }
            equipamento.setStatusEquipamento(equipamentoAtualizado.isStatusEquipamento());  // Atualiza o status
            equipamento.setDataAquisicao(equipamentoAtualizado.getDataAquisicao());  // Atualiza a data de aquisição

            // Salva o equipamento atualizado no banco de dados
            return equipamentoRepository.save(equipamento);
        } else {
            // Se não encontrar o equipamento, podemos lançar uma exceção ou retornar null
            return null; // Ou você pode lançar uma exceção personalizada
        }
    }

    public void deletarEquipamento(Long id) {
    }

    public List<EquipamentoModel> buscarPorStatus(String status){
        StatusEnum statusEnum = StatusEnum.valueOf(status.toUpperCase());
        return equipamentoRepository.findByStatus(statusEnum);
    }
}
