package controlequi.com.br.controlequi.Repository;

import controlequi.com.br.controlequi.Model.TecnicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<TecnicoModel, Long> {

}
