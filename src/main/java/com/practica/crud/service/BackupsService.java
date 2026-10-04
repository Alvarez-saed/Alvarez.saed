package com.practica.crud.service;

import com.practica.crud.dto.BackupsDTO;
import com.practica.crud.model.Backups;
import com.practica.crud.repository.BackupsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BackupsService {

    private final BackupsRepository backupsRepository;

    public BackupsService(BackupsRepository backupsRepository) {
        this.backupsRepository = backupsRepository;
    }

    private BackupsDTO toDTO(Backups entidad) {
        BackupsDTO dto = new BackupsDTO();
        dto.setId(entidad.getId());
        dto.setNombre(entidad.getNombre());
        dto.setRutaArchivo(entidad.getRutaArchivo());
        dto.setFechaCreacion(entidad.getFechaCreacion());
        dto.setTamaño(entidad.getTamaño());
        dto.setActivo(entidad.getActivo());
        return dto;
    }

    private Backups toEntity(BackupsDTO dto) {
        Backups entidad = new Backups();
        entidad.setId(dto.getId());
        entidad.setNombre(dto.getNombre());
        entidad.setRutaArchivo(dto.getRutaArchivo());
        entidad.setFechaCreacion(dto.getFechaCreacion());
        entidad.setTamaño(dto.getTamaño());
        entidad.setActivo(dto.getActivo());
        return entidad;
    }

    public List<BackupsDTO> listar() {
        return backupsRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<BackupsDTO> buscarPorId(Long id) {
        return backupsRepository.findById(id).map(this::toDTO);
    }

    public BackupsDTO crear(BackupsDTO dto) {
        return toDTO(backupsRepository.save(toEntity(dto)));
    }

    public Optional<BackupsDTO> actualizar(Long id, BackupsDTO dto) {
        return backupsRepository.findById(id).map(existente -> {
            Backups actualizado = toEntity(dto);
            actualizado.setId(id);
            return toDTO(backupsRepository.save(actualizado));
        });
    }

    public boolean eliminar(Long id) {
        if (backupsRepository.existsById(id)) {
            backupsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}