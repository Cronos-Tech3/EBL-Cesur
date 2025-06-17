package com.example.portfolio.service;

import com.example.portfolio.model.Lenguaje;
import com.example.portfolio.model.Proyecto;
import com.example.portfolio.repository.LenguajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LenguajeService {
    @Autowired
    LenguajeRepository lenguajeRepository;

    public List<Lenguaje> getAllLenguajes(){
        return lenguajeRepository.findAll();
    }

}
