package com.practica.crud.service;

import com.practica.crud.dto.ObjetivoGastoDTO;
import com.practica.crud.model.ObjetivoGasto;
import com.practica.crud.repository.ObjetivoGastoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ObjetivoGastoService {

    private final ObjetivoGastoRepository fuenteDatos;

    private ObjetivoGastoDTO convertirADTO(ObjetivoGasto entidad) {
        ObjetivoGastoDTO dto = new ObjetivoGastoDTO();
        dto.setCodigoRegistro(entidad.getCodigoRegistro());
        dto.setClaveObjetivo(entidad.getClaveObjetivo());
        dto.setDescripcion(entidad.getDescripcion());
        dto.setCategoria(entidad.getCategoria());
        dto.setVigente(entidad.isVigente());
        return dto;
    }

    private ObjetivoGasto convertirAEntidad(ObjetivoGastoDTO dto) {
        ObjetivoGasto reg = new ObjetivoGasto();
        reg.setCodigoRegistro(dto.getCodigoRegistro());
        reg.setClaveObjetivo(dto.getClaveObjetivo());
        reg.setDescripcion(dto.getDescripcion());
        reg.setCategoria(dto.getCategoria());
        reg.setVigente(dto.isVigente());
        return reg;
    }

    public List<ObjetivoGastoDTO> listarTodo() {
        return fuenteDatos.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public Optional<ObjetivoGastoDTO> buscarPorCodigo(Long id) {
        return fuenteDatos.findById(id).map(this::convertirADTO);
    }

    public ObjetivoGastoDTO registrar(ObjetivoGastoDTO datos) {
        return convertirADTO(fuenteDatos.save(convertirAEntidad(datos)));
    }

    public Optional<ObjetivoGastoDTO> actualizarRegistro(Long id, ObjetivoGastoDTO datos) {
        return fuenteDatos.findById(id).map(existente -> {
            ObjetivoGasto actual = convertirAEntidad(datos);
            actual.setCodigoRegistro(id);
            return convertirADTO(fuenteDatos.save(actual));
        });
    }

    public boolean borrar(Long id) {
        if (fuenteDatos.existsById(id)) {
            fuenteDatos.deleteById(id);
            return true;
        }
        return false;
    }
}