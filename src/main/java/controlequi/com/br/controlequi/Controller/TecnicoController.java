package controlequi.com.br.controlequi.Controller;

import controlequi.com.br.controlequi.Model.FuncionarioModel;
import controlequi.com.br.controlequi.Service.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tecnicos")
@Tag(name = "Tecnicos", description = "Endpoints para gerenciamento de técnicos")
public class TecnicoController {

    private final FuncionarioService funcionarioService;

    public TecnicoController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    @Operation(summary = "Lista todos os técnicos cadastrados")
    public List<FuncionarioModel> listarTecnicos() {
        return funcionarioService.listarTecnicos();
    }
}
