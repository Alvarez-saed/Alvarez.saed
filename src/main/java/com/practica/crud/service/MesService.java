package com.practica.crud.service;

import com.practica.crud.dto.MesDTO;
import com.practica.crud.model.Mes;
import com.practica.crud.repository.MesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MesService {

    private final MesRepository almacenDatos;

    private MesDTO convertirSalida(Mes entidad) {
        MesDTO dto = new MesDTO();
        dto.setCodigoInterno(entidad.getCodigoInterno());
        dto.setNumeroMes(entidad.getNumeroMes());
        dto.setNombreMes(entidad.getNombreMes());
        dto.setDiasTotales(entidad.getDiasTotales());
        dto.setActivo(entidad.isActivo());
        return dto;
    }

    private Mes convertirEntidad(MesDTO dto) {
        Mes registro = new Mes();
        registro.setCodigoInterno(dto.getCodigoInterno());
        registro.setNumeroMes(dto.getNumeroMes());
        registro.setNombreMes(dto.getNombreMes());
        registro.setDiasTotales(dto.getDiasTotales());
        registro.setActivo(dto.isActivo());
        return registro;
    }

    public List<MesDTO> consultarTodos() {
        return almacenDatos.findAll()
                .stream()
                .map(this::convertirSalida)
                .collect(Collectors.toList());
    }

    public Optional<MesDTO> localizar(Long id) {
        return almacenDatos.findById(id).map(this::convertirSalida);
    }

    public MesDTO agregar(MesDTO datos) {
        return convertirSalida(almacenDatos.save(convertirEntidad(datos)));
    }

    public Optional<MesDTO> modificar(Long id, MesDTO datos) {
        return almacenDatos.findById(id).map(existente -> {
            Mes actualizado = convertirEntidad(datos);
            actualizado.setCodigoInterno(id);
            return convertirSalida(almacenDatos.save(actualizado));
        });
    }

    public boolean eliminarRegistro(Long id) {
        if (almacenDatos.existsById(id)) {
            almacenDatos.deleteById(id);
            return true;
        }
        return false;
    }
}