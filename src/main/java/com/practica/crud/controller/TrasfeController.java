package com.practica.crud.controller;

import com.practica.crud.dto.TrasfeDTO;
import com.practica.crud.service.TrasfeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trasfe")
public class TrasfeController {

    private final TrasfeService gestionTraslados;

    public TrasfeController(TrasfeService gestionTraslados) {
        this.gestionTraslados = gestionTraslados;
    }

    @GetMapping
    public ResponseEntity<List<TrasfeDTO>> consultarTodos() {
        return ResponseEntity.ok(gestionTraslados.listarTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrasfeDTO> buscar(@PathVariable Long id) {
        return gestionTraslados.buscarPorCodigo(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TrasfeDTO> crear(@RequestBody TrasfeDTO dto) {
        return ResponseEntity.ok(gestionTraslados.registrarTraslado(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrasfeDTO> actualizar(
            @PathVariable Long id,
            @RequestBody TrasfeDTO dto) {
        return gestionTraslados.modificarTraslado(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (gestionTraslados.eliminarRegistro(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}