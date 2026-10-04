package com.practica.crud.service;

import com.practica.crud.dto.UniAdmDTO;
import com.practica.crud.model.UniAdm;
import com.practica.crud.repository.UniAdmRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UniAdmService {

    private final UniAdmRepository uniAdmRepository;

    public UniAdmService(UniAdmRepository uniAdmRepository) {
        this.uniAdmRepository = uniAdmRepository;
    }

    private UniAdmDTO convertirADTO(UniAdm entidad) {
        UniAdmDTO dto = new UniAdmDTO();
        dto.setCodigo(entidad.getCodigo());
        dto.setClaveUnidad(entidad.getClaveUnidad());
        dto.setNombreCompleto(entidad.getNombreCompleto());
        dto.setNivelJerarquico(entidad.getNivelJerarquico());
        dto.setUbicacion(entidad.getUbicacion());
        dto.setActivo(entidad.isActivo());
        return dto;
    }

    private UniAdm convertirAEntidad(UniAdmDTO dto) {
        UniAdm registro = new UniAdm();
        registro.setCodigo(dto.getCodigo());
        registro.setClaveUnidad(dto.getClaveUnidad());
        registro.setNombreCompleto(dto.getNombreCompleto());
        registro.setNivelJerarquico(dto.getNivelJerarquico());
        registro.setUbicacion(dto.getUbicacion());
        registro.setActivo(dto.isActivo());
        return registro;
    }

    public List<UniAdmDTO> listarTodo() {
        return uniAdmRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public Optional<UniAdmDTO> buscarPorCodigo(Long id) {
        return uniAdmRepository.findById(id).map(this::convertirADTO);
    }

    public UniAdmDTO registrarUnidad(UniAdmDTO datos) {
        return convertirADTO(uniAdmRepository.save(convertirAEntidad(datos)));
    }

    public Optional<UniAdmDTO> modificarDatos(Long id, UniAdmDTO datos) {
        return uniAdmRepository.findById(id).map(existente -> {
            UniAdm actualizado = convertirAEntidad(datos);
            actualizado.setCodigo(id);
            return convertirADTO(uniAdmRepository.save(actualizado));
        });
    }

    public boolean eliminarRegistro(Long id) {
        if (uniAdmRepository.existsById(id)) {
            uniAdmRepository.deleteById(id);
            return true;
        }
        return false;
    }
}