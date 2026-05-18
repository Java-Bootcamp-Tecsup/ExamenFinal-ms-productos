package com.examenFinal.ms_productos.repository;

import com.examenFinal.ms_productos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
