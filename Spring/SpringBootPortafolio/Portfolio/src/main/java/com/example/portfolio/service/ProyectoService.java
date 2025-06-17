package com.example.portfolio.service;

import com.example.portfolio.model.Proyecto;
import com.example.portfolio.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoService {
    @Autowired
    ProyectoRepository proyectoRepository;
    public List<Proyecto> getAllProyectos() {
        return proyectoRepository.findAll();
    }
    public Proyecto getProyectoById(Long id) {
        return proyectoRepository.findById(id).orElse(null);
    }
}
