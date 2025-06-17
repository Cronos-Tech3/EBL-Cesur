package com.example.portfolio.controller;

import com.example.portfolio.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador básico para manejar las peticiones relacionadas con los proyectos.
 * Este controlador permite listar todos los proyectos y ver los detalles de un proyecto específico.
 */
@Controller  // Indica que esta clase es un controlador de Spring MVC, responsable de manejar peticiones web.
public class BasicController {
    /**
     * Servicio para acceder a la lógica de negocio de los proyectos.
     */
    @Autowired      // Utiliza la inyección de dependencias de Spring para obtener una instancia de ProyectoService.
    ProyectoService proyectoService;     // Declara una variable para el servicio ProyectoService, que contendrá la lógica de negocio de los proyectos.

    /**
     * Muestra la página principal con la lista de todos los proyectos.
     * La petición a la ruta "/proyectos" será manejada por este metodo.
     * Los proyectos obtenidos del servicio se añaden al modelo para ser mostrados en la vista "index".
     *
     * @param model Objeto Model de Spring para pasar datos a la vista.
     * @return El nombre de la vista a renderizar (en este caso, "index").
     */
    @RequestMapping("/proyectos") // Mapea las peticiones HTTP GET a la ruta "/proyectos" a este método.
    String index(Model model){ // Define el metodo 'index' que recibe un objeto 'Model' para pasar datos a la vista.
        model.addAttribute("proyectos", proyectoService.getAllProyectos()); // Llama al método del servicio para obtener todos los proyectos y los añade al 'Model' con la clave "proyectos".
        return "index"; // Retorna el nombre de la vista que se renderizará (normalmente un archivo HTML llamado "index").
    }

    /**
     * Muestra la página de detalles de un proyecto específico.
     * La petición a la ruta "/proyectos/{id}" será manejada por este método, donde {id} es el ID del proyecto.
     * El proyecto obtenido del servicio utilizando el ID se añade al modelo para ser mostrado en la vista "vistaProyecto".
     *
     * @param id    El ID del proyecto a mostrar, extraído de la URL.
     * @param model Objeto Model de Spring para pasar datos a la vista.
     * @return El nombre de la vista a renderizar (en este caso, "vistaProyecto").
     */
    @RequestMapping("/proyectos/{id}") // Mapea las peticiones HTTP GET a rutas como "/proyectos/1", donde {id} es una variable en la URL.
    String portfolio(@PathVariable Integer id, Model model){ // Define el método 'portfolio' que recibe el 'id' de la URL como un Integer y un objeto 'Model'.
        model.addAttribute("proyecto", proyectoService.getProyectoById(id)); // Llama al método del servicio para obtener un proyecto por su ID y lo añade al 'Model' con la clave "proyecto".
        return "vistaProyecto"; // Retorna el nombre de la vista que se renderizará (normalmente un archivo HTML llamado "vistaProyecto").
    }
}
