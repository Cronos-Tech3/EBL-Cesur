package com.example.portfolio.controller;

import com.example.portfolio.model.Proyecto;
import com.example.portfolio.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST para la gestión de proyectos.
 * Esta clase define los endpoints para interactuar con los recursos de proyecto.
 */
@RestController // Indica que esta clase es un controlador REST que maneja solicitudes web y devuelve respuestas en formato JSON o XML.
@RequestMapping("/proyectos") // Define la ruta base para todos los endpoints definidos en este controlador. Las peticiones que comiencen con "/proyectos" serán manejadas aquí.
public class ProyectoController {

    /**
     * Inyección de dependencia del servicio de proyectos.
     * Spring gestiona la creación e inyección de una instancia de ProyectoService.
     */
    @Autowired // Anotación de Spring que permite la inyección automática de dependencias. En este caso, inyecta una instancia de ProyectoService.
    ProyectoService proyectoService; // Declaración de una variable de tipo ProyectoService. Esta variable contendrá la instancia inyectada del servicio.

    /**
     * Endpoint para obtener la lista de todos los proyectos.
     * Este método responde a las peticiones GET a la ruta "/proyectos".
     * @return Una lista de objetos Proyecto, representando todos los proyectos disponibles.
     */
    public List<Proyecto> verJuegos(){
        // Llama al método del servicio para obtener todos los proyectos.
        return proyectoService.getAllProyectos(); // Invoca el método 'getAllProyectos()' del servicio ProyectoService para obtener la lista de todos los proyectos y la devuelve.
    }
}
