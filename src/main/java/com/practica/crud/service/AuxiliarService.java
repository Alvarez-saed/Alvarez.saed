package com.practica.crud.service;

import com.practica.crud.dto.AuxiliarDTO;
import com.practica.crud.model.Auxiliar;  // ← model
import com.practica.crud.repository.AuxiliarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuxiliarService {

    private final AuxiliarRepository auxiliarRepository;

    public AuxiliarService(AuxiliarRepository auxiliarRepository) {
        this.auxiliarRepository = auxiliarRepository;
    }

    private AuxiliarDTO toDTO(Auxiliar entidad) {
        AuxiliarDTO dto = new AuxiliarDTO();
        dto.setId(entidad.getId());
        dto.setCodigo(entidad.getCodigo());
        dto.setNombre(entidad.getNombre());
        dto.setDescripcion(entidad.getDescripcion());
        dto.setActivo(entidad.getActivo());
        return dto;
    }

    private Auxiliar toEntity(AuxiliarDTO dto) {
        Auxiliar entidad = new Auxiliar();
        entidad.setId(dto.getId());
        entidad.setCodigo(dto.getCodigo());
        entidad.setNombre(dto.getNombre());
        entidad.setDescripcion(dto.getDescripcion());
        entidad.setActivo(dto.getActivo());
        return entidad;
    }

    public List<AuxiliarDTO> listar() {
        return auxiliarRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<AuxiliarDTO> buscarPorId(Long id) {
        return auxiliarRepository.findById(id).map(this::toDTO);
    }

    public AuxiliarDTO crear(AuxiliarDTO dto) {
        return toDTO(auxiliarRepository.save(toEntity(dto)));
    }

    public Optional<AuxiliarDTO> actualizar(Long id, AuxiliarDTO dto) {
        return auxiliarRepository.findById(id).map(existente -> {
            Auxiliar actualizado = toEntity(dto);
            actualizado.setId(id);
            return toDTO(auxiliarRepository.save(actualizado));
        });
    }

    public boolean eliminar(Long id) {
        if (auxiliarRepository.existsById(id)) {
            auxiliarRepository.deleteById(id);
            return true;
        }
        return false;
    }
}