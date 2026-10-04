package com.practica.crud.controller;

import com.practica.crud.dto.OrgFinDTO;
import com.practica.crud.service.OrgFinService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organismo-fin")
public class OrgFinController {

    private final OrgFinService orgFinService;

    public OrgFinController(OrgFinService orgFinService) {
        this.orgFinService = orgFinService;
    }

    @GetMapping
    public ResponseEntity<List<OrgFinDTO>> consultar() {
        return ResponseEntity.ok(orgFinService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrgFinDTO> buscar(@PathVariable Long id) {
        return orgFinService.buscarPorCodigo(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrgFinDTO> crear(@RequestBody OrgFinDTO dto) {
        return ResponseEntity.ok(orgFinService.registrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrgFinDTO> actualizar(
            @PathVariable Long id,
            @RequestBody OrgFinDTO dto) {
        return orgFinService.modificar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (orgFinService.eliminarRegistro(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}