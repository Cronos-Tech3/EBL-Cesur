package com.example.portfolio.repository;

import com.example.portfolio.model.Lenguaje;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz que define el repositorio para la entidad Lenguaje.
 * Esta interfaz extiende JpaRepository, proporcionando métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Borrar)
 * en la tabla "Lenguaje".
 */
public interface LenguajeRepository extends JpaRepository<Lenguaje,Integer> {
    // JpaRepository<Lenguaje, Integer> proporciona métodos genéricos para interactuar con la base de datos
    // para la entidad Lenguaje, donde Integer es el tipo del ID (la clave primaria).
    // No es necesario declarar métodos adicionales para las operaciones básicas, ya que JpaRepository los proporciona.
}
