package com.practica.crud.controller;

import com.practica.crud.dto.ConfigDTO;
import com.practica.crud.service.ConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/config")
public class ConfigController {

    private final ConfigService gestionParametros;

    public ConfigController(ConfigService gestionParametros) {
        this.gestionParametros = gestionParametros;
    }

    @GetMapping
    public ResponseEntity<List<ConfigDTO>> consultar() {
        return ResponseEntity.ok(gestionParametros.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConfigDTO> buscar(@PathVariable Long id) {
        return gestionParametros.buscarPorClave(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ConfigDTO> crearNuevo(@RequestBody ConfigDTO datos) {
        return ResponseEntity.ok(gestionParametros.agregar(datos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConfigDTO> actualizarRegistro(
            @PathVariable Long id,
            @RequestBody ConfigDTO datos) {
        return gestionParametros.modificar(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (gestionParametros.quitar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}