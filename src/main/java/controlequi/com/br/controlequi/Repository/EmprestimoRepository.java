package controlequi.com.br.controlequi.Repository;

import controlequi.com.br.controlequi.Model.EmprestimoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<EmprestimoModel, Long> {

}
