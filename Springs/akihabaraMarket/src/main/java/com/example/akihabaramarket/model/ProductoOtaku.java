package com.example.akihabaramarket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Representa un producto Otaku en el sistema de gestión del mercado.
 * Esta clase es una entidad JPA (Java Persistence API), lo que significa que
 * se mapea a una tabla en la base de datos. Cada instancia de {@code ProductoOtaku}
 * corresponde a una fila en esa tabla.
 */
@Entity // Indica que esta clase es una entidad JPA y se mapeará a una tabla de base de datos.
public class ProductoOtaku {

    /**
     * Identificador único del producto.
     * {@code @Id}: Marca este campo como la clave primaria de la entidad.
     * {@code @GeneratedValue(strategy = GenerationType.IDENTITY)}: Configura la estrategia de generación
     * automática del valor del ID. {@code IDENTITY} indica que la base de datos (por ejemplo, MySQL con AUTO_INCREMENT)
     * se encargará de generar el valor del ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del producto Otaku (ej. "Figura de Goku", "Manga One Piece Vol. 1").
     */
    private String nombre;

    /**
     * Categoría a la que pertenece el producto (ej. "Figuras", "Manga", "Ropa", "Coleccionables").
     */
    private String categoria;

    /**
     * Precio del producto. Utiliza {@code Double} para permitir valores decimales.
     */
    private Double precio;

    /**
     * Cantidad de unidades de este producto disponibles en stock.
     */
    private Integer stock;

    /**
     * Constructor por defecto requerido por JPA.
     */
    public ProductoOtaku() {
    }

    /**
     * Constructor para crear una instancia de {@code ProductoOtaku} con todos sus atributos.
     *
     * @param nombre El nombre del producto.
     * @param categoria La categoría del producto.
     * @param precio El precio del producto.
     * @param stock La cantidad en stock del producto.
     */
    public ProductoOtaku(String nombre, String categoria, Double precio, Integer stock) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * Obtiene el ID del producto.
     *
     * @return El ID del producto.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del producto. Este método suele ser utilizado por el framework JPA
     * o en casos específicos donde el ID necesita ser asignado manualmente (raro con IDENTITY).
     *
     * @param id El nuevo ID del producto.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre El nuevo nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la categoría del producto.
     *
     * @return La categoría del producto.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría del producto.
     *
     * @param categoria La nueva categoría del producto.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return El precio del producto.
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio El nuevo precio del producto.
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la cantidad en stock del producto.
     *
     * @return La cantidad en stock del producto.
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * Establece la cantidad en stock del producto.
     *
     * @param stock La nueva cantidad en stock del producto.
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * Sobreescribe el método toString() para proporcionar una representación de cadena legible del objeto.
     * Esto es útil para depuración y logging.
     *
     * @return Una cadena que representa el objeto {@code ProductoOtaku}.
     */
    @Override
    public String toString() {
        return "ProductoOtaku{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}