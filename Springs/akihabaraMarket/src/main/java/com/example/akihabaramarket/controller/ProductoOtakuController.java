package com.example.akihabaramarket.controller;

import com.example.akihabaramarket.model.ProductoOtaku;
import com.example.akihabaramarket.repository.ProductoOtakuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST para gestionar las operaciones relacionadas con los productos Otaku.
 * Esta clase expone una API REST para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * sobre la entidad {@link ProductoOtaku}.
 *
 * Anotado con {@code @RestController}, combina {@code @Controller} y {@code @ResponseBody},
 * lo que significa que los métodos de este controlador devuelven directamente objetos que
 * se serializan automáticamente a JSON o XML.
 *
 * La anotación {@code @RequestMapping("/productos")} define la ruta base para todas
 * las operaciones de este controlador, es decir, todos los endpoints comenzarán con "/productos".
 */
@RestController
@RequestMapping("/productos")
public class ProductoOtakuController {

    /**
     * Inyección de dependencia del repositorio de {@link ProductoOtaku}.
     * Spring se encarga de crear e inyectar una instancia de {@code ProductoOtakuRepository}
     * en este controlador. Este repositorio es la interfaz para interactuar con la base de datos.
     */
    @Autowired
    private ProductoOtakuRepository productoRepository;

    /**
     * Obtiene una lista de todos los productos Otaku disponibles.
     * Este método responde a solicitudes GET a la ruta base "/productos".
     *
     * @return Una {@link List} de objetos {@link ProductoOtaku} representando todos los productos.
     */
    @GetMapping
    public List<ProductoOtaku> obtenerTodosProductos() {
        // Llama al método findAll() del repositorio para obtener todos los productos de la base de datos.
        return productoRepository.findAll();
    }

    /**
     * Obtiene un producto Otaku específico por su ID.
     * Este método responde a solicitudes GET a la ruta "/productos/{id}", donde {id} es una variable de ruta.
     *
     * @param id El ID único del producto a buscar. Se extrae de la URL gracias a {@code @PathVariable}.
     * @return El objeto {@link ProductoOtaku} si se encuentra, o {@code null} si no existe un producto con el ID dado.
     */
    @GetMapping("/{id}")
    public ProductoOtaku obtenerProductoPorId(@PathVariable Long id) {
        // Busca un producto por su ID. findById() devuelve un Optional<ProductoOtaku>.
        // .orElse(null) se usa para devolver null si el producto no se encuentra,
        // aunque en un entorno real se preferiría lanzar una excepción personalizada (ej. NotFoundException)
        // y manejarla con un @ControllerAdvice.
        return productoRepository.findById(id).orElse(null);
    }

    /**
     * Agrega un nuevo producto Otaku a la base de datos.
     * Este método responde a solicitudes POST a la ruta base "/productos".
     * El cuerpo de la solicitud HTTP debe contener los datos del producto en formato JSON o XML,
     * los cuales son mapeados automáticamente al objeto {@link ProductoOtaku} gracias a {@code @RequestBody}.
     *
     * @param producto El objeto {@link ProductoOtaku} enviado en el cuerpo de la solicitud.
     * @return El objeto {@link ProductoOtaku} guardado, incluyendo cualquier ID generado por la base de datos.
     */
    @PostMapping
    public ProductoOtaku agregarProducto(@RequestBody ProductoOtaku producto) {
        // Guarda el nuevo producto en la base de datos.
        return productoRepository.save(producto);
    }

    /**
     * Actualiza un producto Otaku existente por su ID.
     * Este método responde a solicitudes PUT a la ruta "/productos/{id}".
     * El cuerpo de la solicitud HTTP debe contener los datos actualizados del producto.
     *
     * @param id El ID del producto a actualizar, extraído de la URL.
     * @param productoActualizado El objeto {@link ProductoOtaku} con los nuevos datos, enviado en el cuerpo de la solicitud.
     * @return El objeto {@link ProductoOtaku} actualizado si se encuentra y modifica, o {@code null} si el producto no existe.
     */
    @PutMapping("/{id}")
    public ProductoOtaku actualizarProducto(@PathVariable Long id, @RequestBody ProductoOtaku productoActualizado) {
        // Busca el producto existente por su ID.
        return productoRepository.findById(id)
                // Si el producto se encuentra (es decir, el Optional contiene un valor), se mapea y actualiza.
                .map(producto -> {
                    // Actualiza los campos del producto existente con los valores del producto recibido.
                    producto.setNombre(productoActualizado.getNombre());
                    producto.setCategoria(productoActualizado.getCategoria());
                    producto.setPrecio(productoActualizado.getPrecio());
                    producto.setStock(productoActualizado.getStock());
                    // Guarda el producto actualizado en la base de datos.
                    return productoRepository.save(producto);
                })
                // Si el producto no se encuentra (el Optional está vacío), se devuelve null.
                // Nuevamente, en un entorno de producción, se preferiría una gestión de errores más robusta.
                .orElse(null);
    }

    /**
     * Elimina un producto Otaku de la base de datos por su ID.
     * Este método responde a solicitudes DELETE a la ruta "/productos/{id}".
     *
     * @param id El ID del producto a eliminar, extraído de la URL.
     */
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        // Elimina el producto de la base de datos por su ID.
        productoRepository.deleteById(id);
    }
}
