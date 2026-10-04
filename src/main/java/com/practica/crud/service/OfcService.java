package com.practica.crud.service;

import com.practica.crud.dto.OfcDTO;
import com.practica.crud.model.Ofc;
import com.practica.crud.repository.OfcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OfcService {

    private final OfcRepository ofcRepository;

    private OfcDTO convertirADTO(Ofc entidad) {
        OfcDTO dto = new OfcDTO();
        dto.setCodigo(entidad.getCodigo());
        dto.setClaveOficina(entidad.getClaveOficina());
        dto.setNombreOficina(entidad.getNombreOficina());
        dto.setDireccion(entidad.getDireccion());
        dto.setTelefono(entidad.getTelefono());
        dto.setActivo(entidad.isActivo());
        return dto;
    }

    private Ofc convertirAEntidad(OfcDTO dto) {
        Ofc registro = new Ofc();
        registro.setCodigo(dto.getCodigo());
        registro.setClaveOficina(dto.getClaveOficina());
        registro.setNombreOficina(dto.getNombreOficina());
        registro.setDireccion(dto.getDireccion());
        registro.setTelefono(dto.getTelefono());
        registro.setActivo(dto.isActivo());
        return registro;
    }

    public List<OfcDTO> listarTodos() {
        return ofcRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public Optional<OfcDTO> buscarPorCodigo(Long id) {
        return ofcRepository.findById(id).map(this::convertirADTO);
    }

    public OfcDTO crearRegistro(OfcDTO datos) {
        return convertirADTO(ofcRepository.save(convertirAEntidad(datos)));
    }

    public Optional<OfcDTO> actualizarRegistro(Long id, OfcDTO datos) {
        return ofcRepository.findById(id).map(existente -> {
            Ofc actualizado = convertirAEntidad(datos);
            actualizado.setCodigo(id);
            return convertirADTO(ofcRepository.save(actualizado));
        });
    }

    public boolean eliminarRegistro(Long id) {
        if (ofcRepository.existsById(id)) {
            ofcRepository.deleteById(id);
            return true;
        }
        return false;
    }
}