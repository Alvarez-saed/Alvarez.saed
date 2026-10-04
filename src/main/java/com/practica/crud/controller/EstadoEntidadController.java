package com.practica.crud.controller;

import com.practica.crud.dto.EstadoEntidadDTO;
import com.practica.crud.service.EstadoEntidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/est-ent")
public class EstadoEntidadController {

    private final EstadoEntidadService gestion;

    public EstadoEntidadController(EstadoEntidadService gestion) {
        this.gestion = gestion;
    }

    @GetMapping
    public ResponseEntity<List<EstadoEntidadDTO>> consultar() {
        return ResponseEntity.ok(gestion.listarTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoEntidadDTO> buscar(@PathVariable Long id) {
        return gestion.buscarPorClave(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EstadoEntidadDTO> crear(@RequestBody EstadoEntidadDTO dto) {
        return ResponseEntity.ok(gestion.agregar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoEntidadDTO> actualizar(
            @PathVariable Long id,
            @RequestBody EstadoEntidadDTO dto) {
        return gestion.modificar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (gestion.quitar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}