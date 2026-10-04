package com.practica.crud.controller;

import com.practica.crud.dto.DatoDTO;
import com.practica.crud.service.DatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data")
public class DatoController {

    private final DatoService datoService;

    public DatoController(DatoService datoService) {
        this.datoService = datoService;
    }

    @GetMapping
    public ResponseEntity<List<DatoDTO>> consultar() {
        return ResponseEntity.ok(datoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatoDTO> buscar(@PathVariable Long id) {
        return datoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DatoDTO> crear(@RequestBody DatoDTO dto) {
        return ResponseEntity.ok(datoService.guardarNuevo(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatoDTO> modificar(
            @PathVariable Long id,
            @RequestBody DatoDTO dto) {
        return datoService.actualizarRegistro(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (datoService.borrarPorId(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}