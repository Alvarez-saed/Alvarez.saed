package com.practica.crud.service;

import com.practica.crud.dto.EstadoDTO;
import com.practica.crud.model.Estado;
import com.practica.crud.repository.EstadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstadoService {

    private final EstadoRepository repositorio;

    private EstadoDTO convertirADTO(Estado entidad) {
        EstadoDTO dto = new EstadoDTO();
        dto.setIdentificador(entidad.getIdentificador());
        dto.setClaveEstado(entidad.getClaveEstado());
        dto.setNombreEstado(entidad.getNombreEstado());
        dto.setDetalle(entidad.getDetalle());
        dto.setActivo(entidad.isActivo());
        return dto;
    }

    private Estado convertirAEntidad(EstadoDTO dto) {
        Estado reg = new Estado();
        reg.setIdentificador(dto.getIdentificador());
        reg.setClaveEstado(dto.getClaveEstado());
        reg.setNombreEstado(dto.getNombreEstado());
        reg.setDetalle(dto.getDetalle());
        reg.setActivo(dto.isActivo());
        return reg;
    }

    public List<EstadoDTO> obtenerTodos() {
        return repositorio.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public Optional<EstadoDTO> buscarPorIdentificador(Long id) {
        return repositorio.findById(id).map(this::convertirADTO);
    }

    public EstadoDTO registrarNuevo(EstadoDTO dto) {
        return convertirADTO(repositorio.save(convertirAEntidad(dto)));
    }

    public Optional<EstadoDTO> modificarRegistro(Long id, EstadoDTO dto) {
        return repositorio.findById(id).map(existente -> {
            Estado actual = convertirAEntidad(dto);
            actual.setIdentificador(id);
            return convertirADTO(repositorio.save(actual));
        });
    }

    public boolean borrarRegistro(Long id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return true;
        }
        return false;
    }
}