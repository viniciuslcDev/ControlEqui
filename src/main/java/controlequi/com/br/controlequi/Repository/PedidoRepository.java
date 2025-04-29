package controlequi.com.br.controlequi.Repository;

import controlequi.com.br.controlequi.Model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
}
