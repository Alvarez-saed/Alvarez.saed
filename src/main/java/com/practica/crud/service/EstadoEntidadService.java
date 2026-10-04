package com.practica.crud.service;

import com.practica.crud.dto.EstadoEntidadDTO;
import com.practica.crud.model.EstadoEntidad;
import com.practica.crud.repository.EstadoEntidadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstadoEntidadService {

    private final EstadoEntidadRepository datos;

    private EstadoEntidadDTO convertirADTO(EstadoEntidad entidad) {
        EstadoEntidadDTO dto = new EstadoEntidadDTO();
        dto.setClave(entidad.getClave());
        dto.setCodigoEstado(entidad.getCodigoEstado());
        dto.setNombreEstado(entidad.getNombreEstado());
        dto.setDescripcion(entidad.getDescripcion());
        dto.setVigente(entidad.isVigente());
        return dto;
    }

    private EstadoEntidad convertirAEntidad(EstadoEntidadDTO dto) {
        EstadoEntidad reg = new EstadoEntidad();
        reg.setClave(dto.getClave());
        reg.setCodigoEstado(dto.getCodigoEstado());
        reg.setNombreEstado(dto.getNombreEstado());
        reg.setDescripcion(dto.getDescripcion());
        reg.setVigente(dto.isVigente());
        return reg;
    }

    public List<EstadoEntidadDTO> listarTodo() {
        return datos.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public Optional<EstadoEntidadDTO> buscarPorClave(Long id) {
        return datos.findById(id).map(this::convertirADTO);
    }

    public EstadoEntidadDTO agregar(EstadoEntidadDTO dto) {
        return convertirADTO(datos.save(convertirAEntidad(dto)));
    }

    public Optional<EstadoEntidadDTO> modificar(Long id, EstadoEntidadDTO dto) {
        return datos.findById(id).map(existente -> {
            EstadoEntidad actual = convertirAEntidad(dto);
            actual.setClave(id);
            return convertirADTO(datos.save(actual));
        });
    }

    public boolean quitar(Long id) {
        if (datos.existsById(id)) {
            datos.deleteById(id);
            return true;
        }
        return false;
    }
}