package com.examenFinal.ms_productos.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "productos")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    private String descripcion;

    @NotNull(message = "El precio es requerido")
    private BigDecimal precio;

    @NotNull(message = "El stock es requerido")
    @Min(value = 1, message = "El stock debe ser al menos 1")
    private Integer stock;
    private Boolean estado;
    private LocalDateTime fechaCreacion;
}