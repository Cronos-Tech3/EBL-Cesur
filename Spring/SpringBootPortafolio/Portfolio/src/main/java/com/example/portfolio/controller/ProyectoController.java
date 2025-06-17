package com.example.portfolio.controller;

import com.example.portfolio.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Proyecto")
public class ProyectoController {

@Autowired
    ProyectoService proyectoService;

@GetMapping
    String Vista(ModelMap model){
    model.addAttribute("lista", proyectoService.getAllProyectos());
    return "index";}

@GetMapping("/{id}")
    String verUno(@PathVariable Long id, ModelMap model){
    model.addAttribute("getById", proyectoService.getProyectoById(id));
    return "segunda"; }
}
