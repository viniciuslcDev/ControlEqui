package controlequi.com.br.controlequi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "ControlEqui", version = "0.1", description = "API desenvolvida para Gestão Inteligente de Equipamentos"))
public class ControlequiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlequiApplication.class, args);
	}

}

//teste