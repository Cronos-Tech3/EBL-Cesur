package com.example.portfolio.repository;

import com.example.portfolio.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz que define el repositorio para la entidad Proyecto.
 * Esta interfaz extiende JpaRepository, proporcionando métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Borrar)
 * en la tabla "proyectos".
 */
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {
    // JpaRepository<Proyecto, Integer> proporciona métodos genéricos para interactuar con la base de datos
    // para la entidad Proyecto, donde Integer es el tipo del ID (la clave primaria).
    // No es necesario declarar métodos adicionales para las operaciones básicas, ya que JpaRepository los proporciona.
}
