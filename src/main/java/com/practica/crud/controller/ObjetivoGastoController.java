package com.practica.crud.controller;

import com.practica.crud.dto.ObjetivoGastoDTO;
import com.practica.crud.service.ObjetivoGastoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objgasto")
public class ObjetivoGastoController {

    private final ObjetivoGastoService gestion;

    public ObjetivoGastoController(ObjetivoGastoService gestion) {
        this.gestion = gestion;
    }

    @GetMapping
    public ResponseEntity<List<ObjetivoGastoDTO>> consultar() {
        return ResponseEntity.ok(gestion.listarTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObjetivoGastoDTO> buscar(@PathVariable Long id) {
        return gestion.buscarPorCodigo(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ObjetivoGastoDTO> crear(@RequestBody ObjetivoGastoDTO datos) {
        return ResponseEntity.ok(gestion.registrar(datos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObjetivoGastoDTO> modificar(
            @PathVariable Long id,
            @RequestBody ObjetivoGastoDTO datos) {
        return gestion.actualizarRegistro(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (gestion.borrar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}