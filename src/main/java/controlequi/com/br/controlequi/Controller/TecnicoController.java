package controlequi.com.br.controlequi.Controller;

import controlequi.com.br.controlequi.Model.TecnicoModel;
import controlequi.com.br.controlequi.Service.TecnicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/controller")
public class TecnicoController {
    private final TecnicoService tecnicoService;

    public TecnicoController(TecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }

    @GetMapping
    public List<TecnicoModel> buscarTodosTecnicos(){
        return tecnicoService.listarTodosTecnicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TecnicoModel> buscarPorId(Long id){
        return tecnicoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
