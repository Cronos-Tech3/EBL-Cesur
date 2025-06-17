package com.example.akihabaramarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Spring Boot para Akihabara Market.
 *
 * <p>Esta clase es el punto de entrada de la aplicación.
 * La anotación {@code @SpringBootApplication} es una anotación de conveniencia
 * que combina tres anotaciones clave de Spring Boot:</p>
 * <ul>
 * <li>{@code @Configuration}: Indica que esta clase puede ser usada por el contenedor de Spring
 * como una fuente de definiciones de beans.</li>
 * <li>{@code @EnableAutoConfiguration}: Habilita la configuración automática de Spring Boot,
 * que intenta configurar automáticamente tu aplicación Spring basándose en las dependencias
 * del classpath, propiedades, y otros beans. Por ejemplo, si tienes {@code spring-boot-starter-web}
 * en tu classpath, configurará un servidor Tomcat.</li>
 * <li>{@code @ComponentScan}: Habilita el escaneo de componentes. Busca otros componentes,
 * configuraciones y servicios en el paquete actual y sus subpaquetes para que
 * Spring los detecte y los registre como beans.</li>
 * </ul>
 */
@SpringBootApplication
public class AkihabaraMarketApplication {

    /**
     * Método principal que arranca la aplicación Spring Boot.
     *
     * <p>El método {@code SpringApplication.run()} inicializa y arranca el contexto de la aplicación,
     * configurando todo lo necesario (servidor embebido, beans, etc.) para que la aplicación
     * esté lista para recibir solicitudes.</p>
     *
     * @param args Argumentos de la línea de comandos que se pueden pasar a la aplicación.
     */

    public static void main(String[] args) {
        // Ejecuta la aplicación Spring Boot.
        // Pasa la clase principal de la aplicación (AkihabaraMarketApplication.class)
        // y los argumentos de la línea de comandos.
        SpringApplication.run(AkihabaraMarketApplication.class, args);
    }
}
