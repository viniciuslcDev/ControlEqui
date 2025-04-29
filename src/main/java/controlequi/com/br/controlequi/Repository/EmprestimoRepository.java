package controlequi.com.br.controlequi.Repository;

import controlequi.com.br.controlequi.Model.EmprestimoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<EmprestimoModel, Long> {

    List<EmprestimoModel> findByEquipamentoIdEquipamento(Long idEquipamento);
    List<EmprestimoModel> findByTecnicoIdFuncionario(Long idFuncionario);
    List<EmprestimoModel> findByEquipamentoFuncionarioIdFuncionario(Long idFuncionario);

}
