package com.practica.crud.controller;

import com.practica.crud.dto.CodcontDTO;
import com.practica.crud.service.CodcontService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/codcont")
public class CodcontController {

    private final CodcontService gestionContable;

    public CodcontController(CodcontService gestionContable) {
        this.gestionContable = gestionContable;
    }

    @GetMapping
    public ResponseEntity<List<CodcontDTO>> consultarTodos() {
        return ResponseEntity.ok(gestionContable.listarTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CodcontDTO> buscar(@PathVariable Long id) {
        return gestionContable.buscarPorIdentificador(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CodcontDTO> agregar(@RequestBody CodcontDTO datos) {
        return ResponseEntity.ok(gestionContable.registrar(datos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CodcontDTO> actualizarDatos(
            @PathVariable Long id,
            @RequestBody CodcontDTO datos) {
        return gestionContable.modificar(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id) {
        if (gestionContable.eliminarRegistro(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}