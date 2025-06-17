package com.example.akihabaramarket.repository;

import com.example.akihabaramarket.model.ProductoOtaku;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz de repositorio para la entidad {@link ProductoOtaku}.
 * Esta interfaz extiende {@link JpaRepository}, lo que proporciona automáticamente
 * métodos CRUD (Crear, Leer, Actualizar, Eliminar) para la entidad {@code ProductoOtaku}.
 *
 * <p>Al extender {@code JpaRepository}, Spring Data JPA genera en tiempo de ejecución
 * una implementación de esta interfaz, eliminando la necesidad de escribir manualmente
 * gran parte del código de acceso a datos.</p>
 *
 * <p>Los dos parámetros genéricos de {@code JpaRepository} son:</p>
 * <ul>
 * <li>{@code ProductoOtaku}: El tipo de la entidad con la que este repositorio trabajará.</li>
 * <li>{@code Long}: El tipo de la clave primaria (ID) de la entidad {@code ProductoOtaku}.</li>
 * </ul>
 *
 * <p>Además de los métodos CRUD básicos, se pueden añadir métodos de consulta personalizados
 * a esta interfaz simplemente declarando sus firmas, y Spring Data JPA los implementará
 * automáticamente basándose en las convenciones de nombres de métodos (ej. {@code findByNombre(String nombre)}).</p>
 */
public interface ProductoOtakuRepository extends JpaRepository<ProductoOtaku, Long> {
    // No se necesitan métodos adicionales aquí para las operaciones CRUD básicas,
    // ya que JpaRepository los proporciona por defecto:
    // - save(ProductoOtaku entity): Guarda una entidad en la base de datos.
    // - findById(Long id): Busca una entidad por su ID, devolviendo un Optional.
    // - findAll(): Devuelve una lista de todas las entidades.
    // - deleteById(Long id): Elimina una entidad por su ID.
    // y muchos más.
}