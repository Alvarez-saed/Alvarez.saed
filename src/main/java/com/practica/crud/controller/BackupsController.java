package com.practica.crud.controller;

import com.practica.crud.dto.BackupsDTO;
import com.practica.crud.service.BackupsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/backups")
public class BackupsController {

    private final BackupsService backupsService;

    public BackupsController(BackupsService backupsService) {
        this.backupsService = backupsService;
    }

    @GetMapping
    public ResponseEntity<List<BackupsDTO>> listar() {
        return ResponseEntity.ok(backupsService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BackupsDTO> buscarPorId(@PathVariable Long id) {

        return backupsService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BackupsDTO> crear(@RequestBody BackupsDTO dto) {

        BackupsDTO creado = backupsService.crear(dto);

        return ResponseEntity.ok(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BackupsDTO> actualizar(
            @PathVariable Long id,
            @RequestBody BackupsDTO dto) {

        return backupsService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (backupsService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}