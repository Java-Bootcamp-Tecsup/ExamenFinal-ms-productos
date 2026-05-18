package com.examenFinal.ms_productos.service;

import com.examenFinal.ms_productos.dto.ProductoDTO;
import com.examenFinal.ms_productos.entity.Producto;
import com.examenFinal.ms_productos.exception.ProductoNotFoundException;
import com.examenFinal.ms_productos.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    public Producto crear(ProductoDTO dto) {
        Producto p = new Producto();
        p.setNombre(dto.nombre());
        p.setDescripcion(dto.descripcion());
        p.setPrecio(dto.precio());
        p.setStock(dto.stock());
        p.setEstado(dto.estado() != null ? dto.estado() : true);
        p.setFechaCreacion(LocalDateTime.now());
        return productoRepository.save(p);
    }

    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    public Producto buscarPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException(id));
    }

    public Producto actualizar(Long id, ProductoDTO dto) {
        Producto p = buscarPorId(id);
        p.setNombre(dto.nombre());
        p.setDescripcion(dto.descripcion());
        p.setPrecio(dto.precio());
        p.setStock(dto.stock());
        if (dto.estado() != null) p.setEstado(dto.estado());
        return productoRepository.save(p);
    }

    public void eliminar(Long id) {
        Producto p = buscarPorId(id);
        p.setEstado(false); // logical delete
        productoRepository.save(p);
    }
}