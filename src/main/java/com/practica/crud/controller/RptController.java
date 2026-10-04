package com.practica.crud.controller;

import com.practica.crud.dto.RptDTO;
import com.practica.crud.service.RptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class RptController {

    private final RptService gestionReportes;

    public RptController(RptService gestionReportes) {
        this.gestionReportes = gestionReportes;
    }

    @GetMapping
    public ResponseEntity<List<RptDTO>> consultar() {
        return ResponseEntity.ok(gestionReportes.listarTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RptDTO> buscar(@PathVariable Long id) {
        return gestionReportes.buscarPorCodigo(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RptDTO> crear(@RequestBody RptDTO dto) {
        return ResponseEntity.ok(gestionReportes.registrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RptDTO> actualizar(
            @PathVariable Long id,
            @RequestBody RptDTO dto) {
        return gestionReportes.modificar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (gestionReportes.eliminarRegistro(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}