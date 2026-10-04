package com.practica.crud.controller;

import com.practica.crud.dto.UniAdmDTO;
import com.practica.crud.service.UniAdmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unidadadmin")
public class UniAdmController {

    private final UniAdmService gestionUnidades;

    public UniAdmController(UniAdmService gestionUnidades) {
        this.gestionUnidades = gestionUnidades;
    }

    @GetMapping
    public ResponseEntity<List<UniAdmDTO>> consultarTodos() {
        return ResponseEntity.ok(gestionUnidades.listarTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniAdmDTO> buscar(@PathVariable Long id) {
        return gestionUnidades.buscarPorCodigo(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UniAdmDTO> crear(@RequestBody UniAdmDTO dto) {
        return ResponseEntity.ok(gestionUnidades.registrarUnidad(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UniAdmDTO> actualizar(
            @PathVariable Long id,
            @RequestBody UniAdmDTO dto) {
        return gestionUnidades.modificarDatos(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (gestionUnidades.eliminarRegistro(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}