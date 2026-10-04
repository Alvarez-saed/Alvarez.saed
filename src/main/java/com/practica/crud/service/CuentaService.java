package com.practica.crud.service;

import com.practica.crud.dto.CuentaDTO;
import com.practica.crud.model.Cuenta;
import com.practica.crud.repository.CuentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CuentaService {

    private final CuentaRepository datos;

    private CuentaDTO mapearDto(Cuenta entidad) {
        CuentaDTO dto = new CuentaDTO();
        dto.setCodigo(entidad.getCodigo());
        dto.setNumero(entidad.getNumero());
        dto.setNombre(entidad.getNombre());
        dto.setCategoria(entidad.getCategoria());
        dto.setVigente(entidad.isVigente());
        return dto;
    }

    private Cuenta mapearEntidad(CuentaDTO dto) {
        Cuenta reg = new Cuenta();
        reg.setCodigo(dto.getCodigo());
        reg.setNumero(dto.getNumero());
        reg.setNombre(dto.getNombre());
        reg.setCategoria(dto.getCategoria());
        reg.setVigente(dto.isVigente());
        return reg;
    }

    public List<CuentaDTO> consultarTodo() {
        return datos.findAll()
                .stream()
                .map(this::mapearDto)
                .collect(Collectors.toList());
    }

    public Optional<CuentaDTO> buscar(Long id) {
        return datos.findById(id).map(this::mapearDto);
    }

    public CuentaDTO registrar(CuentaDTO dto) {
        return mapearDto(datos.save(mapearEntidad(dto)));
    }

    public Optional<CuentaDTO> actualizar(Long id, CuentaDTO dto) {
        return datos.findById(id).map(existente -> {
            Cuenta actual = mapearEntidad(dto);
            actual.setCodigo(id);
            return mapearDto(datos.save(actual));
        });
    }

    public boolean borrar(Long id) {
        if (datos.existsById(id)) {
            datos.deleteById(id);
            return true;
        }
        return false;
    }
}