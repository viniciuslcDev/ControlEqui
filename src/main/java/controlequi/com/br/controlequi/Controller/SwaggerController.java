package controlequi.com.br.controlequi.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api")
public class SwaggerController {

//    @Operation(summary = "Endpoint de teste do Swagger")
//    @GetMapping("/mensagem")
//    public String getMensagem() {
//        return "Olá, Swagger!";
//    }
}
