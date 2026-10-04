package com.practica.crud.controller;

import com.practica.crud.dto.EntidadDTO;
import com.practica.crud.service.EntidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entidades")
public class EntidadController {

    private final EntidadService gestor;

    public EntidadController(EntidadService gestor) {
        this.gestor = gestor;
    }

    @GetMapping
    public ResponseEntity<List<EntidadDTO>> consultar() {
        return ResponseEntity.ok(gestor.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntidadDTO> buscar(@PathVariable Long id) {
        return gestor.buscarPorCodigo(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EntidadDTO> agregar(@RequestBody EntidadDTO datos) {
        return ResponseEntity.ok(gestor.registrar(datos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntidadDTO> actualizar(
            @PathVariable Long id,
            @RequestBody EntidadDTO datos) {
        return gestor.modificar(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id) {
        if (gestor.eliminarRegistro(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}