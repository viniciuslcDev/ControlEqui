package controlequi.com.br.controlequi.Repository;

import controlequi.com.br.controlequi.Model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {

    // Aqui você pode adicionar métodos de busca personalizados depois, se quiser, como:
    // Optional<FuncionarioModel> findByCpfFuncionario(String cpfFuncionario);
    // Optional<FuncionarioModel> findByEmailFuncionario(String emailFuncionario);
}
