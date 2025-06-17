package com.example.akihabaramarket.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase global para el manejo de excepciones en la aplicación.
 * Anotada con {@code @ControllerAdvice}, esta clase centraliza el manejo de excepciones
 * para todos los controladores, proporcionando una forma consistente de responder a errores.
 * Esto ayuda a mantener el código de los controladores limpio y enfocado en la lógica de negocio,
 * delegando la gestión de errores a esta clase.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja la excepción {@code MethodArgumentNotValidException}, la cual es lanzada
     * cuando los argumentos de un método de controlador anotados con {@code @Valid}
     * o {@code @Validated} fallan las validaciones.
     *
     * <p>Este método captura los errores de validación, los organiza en un mapa
     * donde la clave es el nombre del campo y el valor es el mensaje de error,
     * y devuelve una respuesta HTTP con el código de estado 400 Bad Request
     * y el mapa de errores en el cuerpo.</p>
     *
     * @param ex La excepción {@code MethodArgumentNotValidException} que contiene los detalles de los errores de validación.
     * @return {@code ResponseEntity} que contiene un mapa de errores (nombre del campo -> mensaje de error)
     * y un código de estado HTTP 400 (Bad Request).
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) // Establece el código de estado HTTP 400 para la respuesta
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        // Inicializa un mapa para almacenar los errores de validación.
        // La clave será el nombre del campo y el valor será el mensaje de error.
        Map<String, String> errors = new HashMap<>();

        // Itera sobre todos los errores de validación presentes en el BindingResult de la excepción.
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            // Se realiza un cast a FieldError para acceder al nombre del campo que falló la validación.
            String fieldName = ((FieldError) error).getField();
            // Se obtiene el mensaje de error predeterminado asociado con la validación.
            String errorMessage = error.getDefaultMessage();
            // Se añade el error al mapa, mapeando el nombre del campo a su mensaje de error.
            errors.put(fieldName, errorMessage);
        });

        // Retorna una ResponseEntity que contiene el mapa de errores como cuerpo de la respuesta
        // y el código de estado HTTP 400 (Bad Request), indicando que la solicitud es inválida.
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


}

