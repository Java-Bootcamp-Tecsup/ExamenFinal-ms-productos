package com.examenFinal.ms_productos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
    @ExceptionHandler(ProductoNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(ProductoNotFoundException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("mensaje", "Producto no encontrado");
        error.put("detalle", ex.getMessage());
        error.put("fecha", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("mensaje", "Datos inválidos");
        error.put("detalle", ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        error.put("fecha", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneral(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("mensaje", "Error interno del servidor");
        error.put("detalle", ex.getMessage());
        error.put("fecha", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
