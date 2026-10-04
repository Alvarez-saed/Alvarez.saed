package com.practica.crud.controller;

import com.practica.crud.dto.OrgUsrDTO;
import com.practica.crud.service.OrgUsrService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orguser")
public class OrgUsrController {

    private final OrgUsrService gestion;

    public OrgUsrController(OrgUsrService gestion) {
        this.gestion = gestion;
    }

    @GetMapping
    public ResponseEntity<List<OrgUsrDTO>> consultar() {
        return ResponseEntity.ok(gestion.listarTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrgUsrDTO> buscar(@PathVariable Long id) {
        return gestion.buscarPorCodigo(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrgUsrDTO> crear(@RequestBody OrgUsrDTO dto) {
        return ResponseEntity.ok(gestion.registrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrgUsrDTO> actualizar(
            @PathVariable Long id,
            @RequestBody OrgUsrDTO dto) {
        return gestion.modificar(id, dto)
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