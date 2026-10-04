package com.practica.crud.service;

import com.practica.crud.dto.BajasDTO;
import com.practica.crud.model.Bajas;
import com.practica.crud.repository.BajasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BajasService {

    private final BajasRepository repositorioBajas;

    private BajasDTO convertirADTO(Bajas entidad) {
        BajasDTO dto = new BajasDTO();
        dto.setCodigoRegistro(entidad.getCodigoRegistro());
        dto.setNumeroBaja(entidad.getNumeroBaja());
        dto.setDescripcionElemento(entidad.getDescripcionElemento());
        dto.setJustificacion(entidad.getJustificacion());
        dto.setFechaRegistro(entidad.getFechaRegistro());
        dto.setEstadoProceso(entidad.getEstadoProceso());
        dto.setVigente(entidad.isVigente());
        return dto;
    }

    private Bajas convertirAEntidad(BajasDTO dto) {
        Bajas entidad = new Bajas();
        entidad.setCodigoRegistro(dto.getCodigoRegistro());
        entidad.setNumeroBaja(dto.getNumeroBaja());
        entidad.setDescripcionElemento(dto.getDescripcionElemento());
        entidad.setJustificacion(dto.getJustificacion());
        entidad.setFechaRegistro(dto.getFechaRegistro());
        entidad.setEstadoProceso(dto.getEstadoProceso());
        entidad.setVigente(dto.isVigente());
        return entidad;
    }

    public List<BajasDTO> obtenerTodos() {
        return repositorioBajas.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public Optional<BajasDTO> buscarPorCodigo(Long id) {
        return repositorioBajas.findById(id).map(this::convertirADTO);
    }

    public BajasDTO registrarNuevo(BajasDTO datos) {
        Bajas guardado = repositorioBajas.save(convertirAEntidad(datos));
        return convertirADTO(guardado);
    }

    public Optional<BajasDTO> actualizarDatos(Long id, BajasDTO datos) {
        return repositorioBajas.findById(id).map(existente -> {
            Bajas entidad = convertirAEntidad(datos);
            entidad.setCodigoRegistro(id);
            return convertirADTO(repositorioBajas.save(entidad));
        });
    }

    public boolean borrarRegistro(Long id) {
        if (repositorioBajas.existsById(id)) {
            repositorioBajas.deleteById(id);
            return true;
        }
        return false;
    }
}