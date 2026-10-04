package com.practica.crud.controller;

import com.practica.crud.dto.RespDTO;
import com.practica.crud.service.RespService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resp")
public class RespController {

    private final RespService gestionResp;

    public RespController(RespService gestionResp) {
        this.gestionResp = gestionResp;
    }

    @GetMapping
    public ResponseEntity<List<RespDTO>> consultar() {
        return ResponseEntity.ok(gestionResp.listarTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespDTO> buscar(@PathVariable Long id) {
        return gestionResp.buscarPorCodigo(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RespDTO> crear(@RequestBody RespDTO dto) {
        return ResponseEntity.ok(gestionResp.registrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespDTO> actualizar(
            @PathVariable Long id,
            @RequestBody RespDTO dto) {
        return gestionResp.modificar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (gestionResp.eliminarRegistro(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}