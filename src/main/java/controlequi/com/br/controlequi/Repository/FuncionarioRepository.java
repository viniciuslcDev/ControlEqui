package controlequi.com.br.controlequi.Repository;

import controlequi.com.br.controlequi.Model.FuncionarioModel;
import controlequi.com.br.controlequi.StatusUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {

    @Query("SELECT f FROM FuncionarioModel f WHERE f.isTecnico = true")
    List<FuncionarioModel> findTecnicos();
    List<FuncionarioModel> findByStatusUsuario(StatusUsuario statusUsuario);
}
