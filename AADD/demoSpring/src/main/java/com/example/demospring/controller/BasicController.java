package com.example.demospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller //Va a devolver objetos, es un manejador de rutas, define cada ruta a donde va
public class BasicController {
    @RequestMapping("/") //cuando no ponga nada me devuelves lo de abajo
    String hola(){
        return "index";
    }
}
