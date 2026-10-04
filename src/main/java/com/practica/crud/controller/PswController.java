package com.practica.crud.controller;

import com.practica.crud.dto.PswDTO;
import com.practica.crud.service.PswService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passw")
public class PswController {

    private final PswService gestionClaves;

    public PswController(PswService gestionClaves) {
        this.gestionClaves = gestionClaves;
    }

    @GetMapping
    public ResponseEntity<List<PswDTO>> consultar() {
        return ResponseEntity.ok(gestionClaves.listarTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PswDTO> buscar(@PathVariable Long id) {
        return gestionClaves.buscarPorCodigo(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PswDTO> crear(@RequestBody PswDTO dto) {
        return ResponseEntity.ok(gestionClaves.registrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PswDTO> actualizar(
            @PathVariable Long id,
            @RequestBody PswDTO dto) {
        return gestionClaves.modificar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (gestionClaves.eliminarRegistro(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}