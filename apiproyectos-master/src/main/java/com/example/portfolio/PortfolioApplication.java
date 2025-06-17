package com.example.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Spring Boot Portfolio.
 * Esta clase es el punto de entrada de la aplicación y está anotada con @SpringBootApplication,
 * que configura automáticamente muchas características de Spring Boot.
 */
@SpringBootApplication // Anotación que combina @Configuration, @EnableAutoConfiguration y @ComponentScan.
// - @Configuration: Marca esta clase como una fuente de definiciones de beans.
// - @EnableAutoConfiguration: Habilita el mecanismo de auto-configuración de Spring Boot,
//   que intenta configurar automáticamente la aplicación basándose en las dependencias del classpath.
// - @ComponentScan: Indica a Spring que busque otros componentes, configuraciones y servicios
//   en el mismo paquete y sus subpaquetes.
public class PortfolioApplication {

	/**
	 * Método principal que se ejecuta al iniciar la aplicación.
	 * @param args Un array de strings que contiene los argumentos de la línea de comandos pasados a la aplicación.
	 */
	public static void main(String[] args) {
		// Llama al método run de SpringApplication para iniciar la aplicación Spring Boot.
		// PortfolioApplication.class especifica la clase principal de la aplicación.
		// args pasa los argumentos de la línea de comandos a la aplicación Spring.
		SpringApplication.run(PortfolioApplication.class, args);
	}

}
