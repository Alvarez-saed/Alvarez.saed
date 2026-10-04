package com.practica.crud.service;

import com.practica.crud.dto.DatoDTO;
import com.practica.crud.model.Dato;
import com.practica.crud.repository.DatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DatoService {

    private final DatoRepository datoRepo;

    private DatoDTO convertirADTO(Dato entidad) {
        DatoDTO dto = new DatoDTO();
        dto.setIdRegistro(entidad.getIdRegistro());
        dto.setEtiqueta(entidad.getEtiqueta());
        dto.setValor(entidad.getValor());
        dto.setGrupo(entidad.getGrupo());
        dto.setActivo(entidad.isActivo());
        return dto;
    }

    private Dato convertirAEntidad(DatoDTO dto) {
        Dato reg = new Dato();
        reg.setIdRegistro(dto.getIdRegistro());
        reg.setEtiqueta(dto.getEtiqueta());
        reg.setValor(dto.getValor());
        reg.setGrupo(dto.getGrupo());
        reg.setActivo(dto.isActivo());
        return reg;
    }

    public List<DatoDTO> listarTodos() {
        return datoRepo.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public Optional<DatoDTO> buscarPorId(Long id) {
        return datoRepo.findById(id).map(this::convertirADTO);
    }

    public DatoDTO guardarNuevo(DatoDTO dto) {
        return convertirADTO(datoRepo.save(convertirAEntidad(dto)));
    }

    public Optional<DatoDTO> actualizarRegistro(Long id, DatoDTO dto) {
        return datoRepo.findById(id).map(existente -> {
            Dato actual = convertirAEntidad(dto);
            actual.setIdRegistro(id);
            return convertirADTO(datoRepo.save(actual));
        });
    }

    public boolean borrarPorId(Long id) {
        if (datoRepo.existsById(id)) {
            datoRepo.deleteById(id);
            return true;
        }
        return false;
    }
}