package com.practica.crud.service;

import com.practica.crud.dto.ConfigDTO;
import com.practica.crud.model.Config;
import com.practica.crud.repository.ConfigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConfigService {

    private final ConfigRepository repositorioConfig;

    private ConfigDTO mapearADTO(Config entidad) {
        ConfigDTO dto = new ConfigDTO();
        dto.setClave(entidad.getClave());
        dto.setNombreParametro(entidad.getNombreParametro());
        dto.setValorParametro(entidad.getValorParametro());
        dto.setDetalle(entidad.getDetalle());
        dto.setActivo(entidad.isActivo());
        return dto;
    }

    private Config mapearAEntidad(ConfigDTO dto) {
        Config param = new Config();
        param.setClave(dto.getClave());
        param.setNombreParametro(dto.getNombreParametro());
        param.setValorParametro(dto.getValorParametro());
        param.setDetalle(dto.getDetalle());
        param.setActivo(dto.isActivo());
        return param;
    }

    public List<ConfigDTO> listarTodos() {
        return repositorioConfig.findAll()
                .stream()
                .map(this::mapearADTO)
                .collect(Collectors.toList());
    }

    public Optional<ConfigDTO> buscarPorClave(Long clave) {
        return repositorioConfig.findById(clave).map(this::mapearADTO);
    }

    public ConfigDTO agregar(ConfigDTO datos) {
        return mapearADTO(repositorioConfig.save(mapearAEntidad(datos)));
    }

    public Optional<ConfigDTO> modificar(Long clave, ConfigDTO datos) {
        return repositorioConfig.findById(clave).map(existente -> {
            Config actualizado = mapearAEntidad(datos);
            actualizado.setClave(clave);
            return mapearADTO(repositorioConfig.save(actualizado));
        });
    }

    public boolean quitar(Long clave) {
        if (repositorioConfig.existsById(clave)) {
            repositorioConfig.deleteById(clave);
            return true;
        }
        return false;
    }
}