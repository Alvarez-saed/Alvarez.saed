package com.practica.crud.controller;

import com.practica.crud.dto.CuentaDTO;
import com.practica.crud.service.CuentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cta-par")
public class CuentaController {

    private final CuentaService servicio;

    public CuentaController(CuentaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public ResponseEntity<List<CuentaDTO>> listar() {
        return ResponseEntity.ok(servicio.consultarTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuentaDTO> buscarPorId(@PathVariable Long id) {
        return servicio.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CuentaDTO> crear(@RequestBody CuentaDTO dto) {
        return ResponseEntity.ok(servicio.registrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CuentaDTO> modificar(
            @PathVariable Long id,
            @RequestBody CuentaDTO dto) {
        return servicio.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (servicio.borrar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}