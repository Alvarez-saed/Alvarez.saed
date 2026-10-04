package com.practica.crud.controller;

import com.practica.crud.dto.RevalDTO;
import com.practica.crud.service.RevalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reval")
public class RevalController {

    private final RevalService gestionReval;

    public RevalController(RevalService gestionReval) {
        this.gestionReval = gestionReval;
    }

    @GetMapping
    public ResponseEntity<List<RevalDTO>> consultarTodo() {
        return ResponseEntity.ok(gestionReval.listarTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RevalDTO> buscar(@PathVariable Long id) {
        return gestionReval.buscarPorCodigo(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RevalDTO> crear(@RequestBody RevalDTO dto) {
        return ResponseEntity.ok(gestionReval.registrarRevalorizacion(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RevalDTO> actualizar(
            @PathVariable Long id,
            @RequestBody RevalDTO dto) {
        return gestionReval.actualizarDatos(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (gestionReval.eliminarRegistro(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}