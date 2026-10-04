package com.practica.crud.controller;

import com.practica.crud.dto.ClaDeptsDTO;
import com.practica.crud.service.ClaDeptsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cla-depts")
public class ClaDeptsController {

    private final ClaDeptsService gestionDepartamentos;

    public ClaDeptsController(ClaDeptsService gestionDepartamentos) {
        this.gestionDepartamentos = gestionDepartamentos;
    }

    @GetMapping
    public ResponseEntity<List<ClaDeptsDTO>> consultarTodos() {
        return ResponseEntity.ok(gestionDepartamentos.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaDeptsDTO> buscar(@PathVariable Long id) {
        return gestionDepartamentos.buscarPorClave(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClaDeptsDTO> agregar(@RequestBody ClaDeptsDTO datos) {
        return ResponseEntity.ok(gestionDepartamentos.registrar(datos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClaDeptsDTO> actualizarRegistro(
            @PathVariable Long id,
            @RequestBody ClaDeptsDTO datos) {
        return gestionDepartamentos.modificar(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id) {
        if (gestionDepartamentos.eliminarPorClave(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}