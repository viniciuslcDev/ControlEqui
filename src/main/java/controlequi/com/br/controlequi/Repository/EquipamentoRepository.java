package controlequi.com.br.controlequi.Repository;

import controlequi.com.br.controlequi.Model.EquipamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquipamentoRepository extends JpaRepository<EquipamentoModel, Long> {

    Optional<EquipamentoModel> findByserialNumber(int serialNumber);
}

