package com.practica.crud.controller;

import com.practica.crud.dto.BajasDTO;
import com.practica.crud.service.BajasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bajas")
public class BajasController {

    private final BajasService servicioBajas;

    public BajasController(BajasService servicioBajas) {
        this.servicioBajas = servicioBajas;
    }

    @GetMapping
    public ResponseEntity<List<BajasDTO>> listarTodo() {
        return ResponseEntity.ok(servicioBajas.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BajasDTO> buscar(@PathVariable Long id) {
        return servicioBajas.buscarPorCodigo(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BajasDTO> crear(@RequestBody BajasDTO datos) {
        return ResponseEntity.ok(servicioBajas.registrarNuevo(datos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BajasDTO> modificar(
            @PathVariable Long id,
            @RequestBody BajasDTO datos) {
        return servicioBajas.actualizarDatos(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (servicioBajas.borrarRegistro(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}