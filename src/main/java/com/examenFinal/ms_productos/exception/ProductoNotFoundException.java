package com.examenFinal.ms_productos.exception;

public class ProductoNotFoundException extends RuntimeException {
    public ProductoNotFoundException(Long id) {
        super("No existe un producto con el ID: "+id);
    }
}
