package com.practica.crud.controller;

import com.practica.crud.dto.EstadoDTO;
import com.practica.crud.service.EstadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

    private final EstadoService gestionEstado;

    public EstadoController(EstadoService gestionEstado) {
        this.gestionEstado = gestionEstado;
    }

    @GetMapping
    public ResponseEntity<List<EstadoDTO>> consultar() {
        return ResponseEntity.ok(gestionEstado.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoDTO> buscar(@PathVariable Long id) {
        return gestionEstado.buscarPorIdentificador(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EstadoDTO> crear(@RequestBody EstadoDTO dto) {
        return ResponseEntity.ok(gestionEstado.registrarNuevo(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoDTO> actualizar(
            @PathVariable Long id,
            @RequestBody EstadoDTO dto) {
        return gestionEstado.modificarRegistro(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (gestionEstado.borrarRegistro(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}