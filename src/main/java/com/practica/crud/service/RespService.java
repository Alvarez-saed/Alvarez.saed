package com.practica.crud.service;

import com.practica.crud.dto.RespDTO;
import com.practica.crud.model.Resp;
import com.practica.crud.repository.RespRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RespService {

    private final RespRepository respRepository;

    public RespService(RespRepository respRepository) {
        this.respRepository = respRepository;
    }

    private RespDTO convertirADTO(Resp entidad) {
        RespDTO dto = new RespDTO();
        dto.setCodigo(entidad.getCodigo());
        dto.setClaveResponsable(entidad.getClaveResponsable());
        dto.setNombreCompleto(entidad.getNombreCompleto());
        dto.setCargo(entidad.getCargo());
        dto.setArea(entidad.getArea());
        dto.setActivo(entidad.isActivo());
        return dto;
    }

    private Resp convertirAEntidad(RespDTO dto) {
        Resp registro = new Resp();
        registro.setCodigo(dto.getCodigo());
        registro.setClaveResponsable(dto.getClaveResponsable());
        registro.setNombreCompleto(dto.getNombreCompleto());
        registro.setCargo(dto.getCargo());
        registro.setArea(dto.getArea());
        registro.setActivo(dto.isActivo());
        return registro;
    }

    public List<RespDTO> listarTodo() {
        return respRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public Optional<RespDTO> buscarPorCodigo(Long id) {
        return respRepository.findById(id).map(this::convertirADTO);
    }

    public RespDTO registrar(RespDTO datos) {
        return convertirADTO(respRepository.save(convertirAEntidad(datos)));
    }

    public Optional<RespDTO> modificar(Long id, RespDTO datos) {
        return respRepository.findById(id).map(existente -> {
            Resp actualizado = convertirAEntidad(datos);
            actualizado.setCodigo(id);
            return convertirADTO(respRepository.save(actualizado));
        });
    }

    public boolean eliminarRegistro(Long id) {
        if (respRepository.existsById(id)) {
            respRepository.deleteById(id);
            return true;
        }
        return false;
    }
}