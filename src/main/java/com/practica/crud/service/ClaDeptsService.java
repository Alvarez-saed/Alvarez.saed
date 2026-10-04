package com.practica.crud.service;

import com.practica.crud.dto.ClaDeptsDTO;
import com.practica.crud.model.ClaDepts;
import com.practica.crud.repository.ClaDeptsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClaDeptsService {

    private final ClaDeptsRepository repoDepartamentos;

    private ClaDeptsDTO mapearADto(ClaDepts entidad) {
        ClaDeptsDTO dto = new ClaDeptsDTO();
        dto.setClaveId(entidad.getClaveId());
        dto.setCodDepto(entidad.getCodDepto());
        dto.setNombreDepartamento(entidad.getNombreDepartamento());
        dto.setDescripcionArea(entidad.getDescripcionArea());
        dto.setNivelJerarquico(entidad.getNivelJerarquico());
        dto.setEstadoActivo(entidad.isEstadoActivo());
        return dto;
    }

    private ClaDepts mapearAEntidad(ClaDeptsDTO dto) {
        ClaDepts entidad = new ClaDepts();
        entidad.setClaveId(dto.getClaveId());
        entidad.setCodDepto(dto.getCodDepto());
        entidad.setNombreDepartamento(dto.getNombreDepartamento());
        entidad.setDescripcionArea(dto.getDescripcionArea());
        entidad.setNivelJerarquico(dto.getNivelJerarquico());
        entidad.setEstadoActivo(dto.isEstadoActivo());
        return entidad;
    }

    public List<ClaDeptsDTO> listarTodos() {
        return repoDepartamentos.findAll()
                .stream()
                .map(this::mapearADto)
                .collect(Collectors.toList());
    }

    public Optional<ClaDeptsDTO> buscarPorClave(Long claveId) {
        return repoDepartamentos.findById(claveId).map(this::mapearADto);
    }

    public ClaDeptsDTO registrar(ClaDeptsDTO datos) {
        return mapearADto(repoDepartamentos.save(mapearAEntidad(datos)));
    }

    public Optional<ClaDeptsDTO> modificar(Long claveId, ClaDeptsDTO datos) {
        return repoDepartamentos.findById(claveId).map(existente -> {
            ClaDepts actualizado = mapearAEntidad(datos);
            actualizado.setClaveId(claveId);
            return mapearADto(repoDepartamentos.save(actualizado));
        });
    }

    public boolean eliminarPorClave(Long claveId) {
        if (repoDepartamentos.existsById(claveId)) {
            repoDepartamentos.deleteById(claveId);
            return true;
        }
        return false;
    }
}