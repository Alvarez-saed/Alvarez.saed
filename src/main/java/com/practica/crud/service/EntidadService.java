package com.practica.crud.service;

import com.practica.crud.dto.EntidadDTO;
import com.practica.crud.model.Entidad;
import com.practica.crud.repository.EntidadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EntidadService {

    private final EntidadRepository almacen;

    private EntidadDTO convertirSalida(Entidad entidad) {
        EntidadDTO dto = new EntidadDTO();
        dto.setCodigoInterno(entidad.getCodigoInterno());
        dto.setSigla(entidad.getSigla());
        dto.setNombreCompleto(entidad.getNombreCompleto());
        dto.setDireccion(entidad.getDireccion());
        dto.setTelefono(entidad.getTelefono());
        dto.setEstadoActivo(entidad.isEstadoActivo());
        return dto;
    }

    private Entidad convertirEntidad(EntidadDTO dto) {
        Entidad reg = new Entidad();
        reg.setCodigoInterno(dto.getCodigoInterno());
        reg.setSigla(dto.getSigla());
        reg.setNombreCompleto(dto.getNombreCompleto());
        reg.setDireccion(dto.getDireccion());
        reg.setTelefono(dto.getTelefono());
        reg.setEstadoActivo(dto.isEstadoActivo());
        return reg;
    }

    public List<EntidadDTO> obtenerTodos() {
        return almacen.findAll()
                .stream()
                .map(this::convertirSalida)
                .collect(Collectors.toList());
    }

    public Optional<EntidadDTO> buscarPorCodigo(Long id) {
        return almacen.findById(id).map(this::convertirSalida);
    }

    public EntidadDTO registrar(EntidadDTO datos) {
        return convertirSalida(almacen.save(convertirEntidad(datos)));
    }

    public Optional<EntidadDTO> modificar(Long id, EntidadDTO datos) {
        return almacen.findById(id).map(existente -> {
            Entidad actual = convertirEntidad(datos);
            actual.setCodigoInterno(id);
            return convertirSalida(almacen.save(actual));
        });
    }

    public boolean eliminarRegistro(Long id) {
        if (almacen.existsById(id)) {
            almacen.deleteById(id);
            return true;
        }
        return false;
    }
}