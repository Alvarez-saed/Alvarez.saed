package com.practica.crud.service;

import com.practica.crud.dto.ActualDTO;
import com.practica.crud.model.Actual;
import com.practica.crud.repository.ActualRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActualService {

    private final ActualRepository actualRepository;

    private ActualDTO toDTO(Actual e) {
        ActualDTO d = new ActualDTO();
        d.setId(e.getId());
        d.setCodigo(e.getCodigo());
        d.setNombre(e.getNombre());
        d.setDescripcion(e.getDescripcion());
        d.setActivo(e.getActivo());
        return d;
    }

    private Actual toEntity(ActualDTO d) {
        Actual e = new Actual();
        e.setId(d.getId());
        e.setCodigo(d.getCodigo());
        e.setNombre(d.getNombre());
        e.setDescripcion(d.getDescripcion());
        e.setActivo(d.getActivo());
        return e;
    }

    public List<ActualDTO> listar() {
        return actualRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<ActualDTO> buscarPorId(Long id) {
        return actualRepository.findById(id).map(this::toDTO);
    }

    public ActualDTO crear(ActualDTO dto) {
        return toDTO(actualRepository.save(toEntity(dto)));
    }

    public Optional<ActualDTO> actualizar(Long id, ActualDTO dto) {
        return actualRepository.findById(id).map(existente -> {
            existente.setCodigo(dto.getCodigo());
            existente.setNombre(dto.getNombre());
            existente.setDescripcion(dto.getDescripcion());
            existente.setActivo(dto.getActivo());
            return toDTO(actualRepository.save(existente));
        });
    }

    public boolean eliminar(Long id) {
        if (actualRepository.existsById(id)) {
            actualRepository.deleteById(id);
            return true;
        }
        return false;
    }
}