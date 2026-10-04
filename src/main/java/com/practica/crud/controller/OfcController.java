package com.practica.crud.controller;

import com.practica.crud.dto.OfcDTO;
import com.practica.crud.service.OfcService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/oficina")
public class OfcController {

    private final OfcService ofcService;

    public OfcController(OfcService ofcService) {
        this.ofcService = ofcService;
    }

    @GetMapping
    public ResponseEntity<List<OfcDTO>> consultar() {
        return ResponseEntity.ok(ofcService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfcDTO> buscar(@PathVariable Long id) {
        return ofcService.buscarPorCodigo(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OfcDTO> crear(@RequestBody OfcDTO dto) {
        return ResponseEntity.ok(ofcService.crearRegistro(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfcDTO> modificar(
            @PathVariable Long id,
            @RequestBody OfcDTO dto) {
        return ofcService.actualizarRegistro(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (ofcService.eliminarRegistro(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}