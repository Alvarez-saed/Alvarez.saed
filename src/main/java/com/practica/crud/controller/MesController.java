package com.practica.crud.controller;

import com.practica.crud.dto.MesDTO;
import com.practica.crud.service.MesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mes")
public class MesController {

    private final MesService gestionMeses;

    public MesController(MesService gestionMeses) {
        this.gestionMeses = gestionMeses;
    }

    @GetMapping
    public ResponseEntity<List<MesDTO>> listar() {
        return ResponseEntity.ok(gestionMeses.consultarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MesDTO> buscar(@PathVariable Long id) {
        return gestionMeses.localizar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MesDTO> crear(@RequestBody MesDTO dto) {
        return ResponseEntity.ok(gestionMeses.agregar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MesDTO> actualizar(
            @PathVariable Long id,
            @RequestBody MesDTO dto) {
        return gestionMeses.modificar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (gestionMeses.eliminarRegistro(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}