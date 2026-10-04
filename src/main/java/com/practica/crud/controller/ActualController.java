package com.practica.crud.controller;

import com.practica.crud.dto.ActualDTO;
import com.practica.crud.service.ActualService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/actual")
@CrossOrigin(origins = "*")
public class ActualController {
    private final ActualService actualService;
    public ActualController(ActualService actualService) {
        this.actualService = actualService;
    }

    @GetMapping
    public ResponseEntity<List<ActualDTO>> listar() {
        return ResponseEntity.ok(actualService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActualDTO> buscarPorId(@PathVariable Long id) {
        return actualService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ActualDTO> crear(@RequestBody ActualDTO dto) {
        return ResponseEntity.ok(actualService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActualDTO> actualizar(@PathVariable Long id, @RequestBody ActualDTO dto) {
        return actualService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return actualService.eliminar(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}