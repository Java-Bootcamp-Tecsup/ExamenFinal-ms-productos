package com.examenFinal.ms_productos.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductoDTO (

    String nombre,
    String descripcion,
    BigDecimal precio,
    Integer stock,
    Boolean estado
){}
