package com.practica.crud.service;

import com.practica.crud.dto.RevalDTO;
import com.practica.crud.model.Reval;
import com.practica.crud.repository.RevalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RevalService {

    private final RevalRepository revalRepository;

    public RevalService(RevalRepository revalRepository) {
        this.revalRepository = revalRepository;
    }

    private RevalDTO convertirADTO(Reval entidad) {
        RevalDTO dto = new RevalDTO();
        dto.setCodigo(entidad.getCodigo());
        dto.setClaveRevalorizacion(entidad.getClaveRevalorizacion());
        dto.setNombreActivo(entidad.getNombreActivo());
        dto.setMontoAnterior(entidad.getMontoAnterior());
        dto.setMontoActual(entidad.getMontoActual());
        dto.setMesProceso(entidad.getMesProceso());
        dto.setVigente(entidad.isVigente());
        return dto;
    }

    private Reval convertirAEntidad(RevalDTO dto) {
        Reval registro = new Reval();
        registro.setCodigo(dto.getCodigo());
        registro.setClaveRevalorizacion(dto.getClaveRevalorizacion());
        registro.setNombreActivo(dto.getNombreActivo());
        registro.setMontoAnterior(dto.getMontoAnterior());
        registro.setMontoActual(dto.getMontoActual());
        registro.setMesProceso(dto.getMesProceso());
        registro.setVigente(dto.isVigente());
        return registro;
    }

    public List<RevalDTO> listarTodo() {
        return revalRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public Optional<RevalDTO> buscarPorCodigo(Long id) {
        return revalRepository.findById(id).map(this::convertirADTO);
    }

    public RevalDTO registrarRevalorizacion(RevalDTO datos) {
        return convertirADTO(revalRepository.save(convertirAEntidad(datos)));
    }

    public Optional<RevalDTO> actualizarDatos(Long id, RevalDTO datos) {
        return revalRepository.findById(id).map(existente -> {
            Reval actualizado = convertirAEntidad(datos);
            actualizado.setCodigo(id);
            return convertirADTO(revalRepository.save(actualizado));
        });
    }

    public boolean eliminarRegistro(Long id) {
        if (revalRepository.existsById(id)) {
            revalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}