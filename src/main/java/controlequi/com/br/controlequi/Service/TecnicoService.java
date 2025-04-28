package controlequi.com.br.controlequi.Service;

import controlequi.com.br.controlequi.Model.TecnicoModel;
import controlequi.com.br.controlequi.Repository.TecnicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {
    private final TecnicoRepository tecnicoRepository;

    public TecnicoService(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }

    public Optional<TecnicoModel> buscarPorId(Long id){
        return tecnicoRepository.findById(id);
    }

    public List<TecnicoModel> listarTodosTecnicos(){
        return tecnicoRepository.findAll();
    }
}
