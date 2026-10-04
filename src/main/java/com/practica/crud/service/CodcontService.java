package com.practica.crud.service;

import com.practica.crud.dto.CodcontDTO;
import com.practica.crud.model.Codcont;
import com.practica.crud.repository.CodcontRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CodcontService {

    private final CodcontRepository repositorioContable;

    private CodcontDTO convertirADatos(Codcont entidad) {
        CodcontDTO dto = new CodcontDTO();
        dto.setIdentificador(entidad.getIdentificador());
        dto.setCodigoCuenta(entidad.getCodigoCuenta());
        dto.setNombreCuenta(entidad.getNombreCuenta());
        dto.setTipoCuenta(entidad.getTipoCuenta());
        dto.setNivelJerarquico(entidad.getNivelJerarquico());
        dto.setVigente(entidad.isVigente());
        return dto;
    }

    private Codcont convertirAEntidad(CodcontDTO dto) {
        Codcont cuenta = new Codcont();
        cuenta.setIdentificador(dto.getIdentificador());
        cuenta.setCodigoCuenta(dto.getCodigoCuenta());
        cuenta.setNombreCuenta(dto.getNombreCuenta());
        cuenta.setTipoCuenta(dto.getTipoCuenta());
        cuenta.setNivelJerarquico(dto.getNivelJerarquico());
        cuenta.setVigente(dto.isVigente());
        return cuenta;
    }

    public List<CodcontDTO> listarTodo() {
        return repositorioContable.findAll()
                .stream()
                .map(this::convertirADatos)
                .collect(Collectors.toList());
    }

    public Optional<CodcontDTO> buscarPorIdentificador(Long id) {
        return repositorioContable.findById(id).map(this::convertirADatos);
    }

    public CodcontDTO registrar(CodcontDTO datos) {
        return convertirADatos(repositorioContable.save(convertirAEntidad(datos)));
    }

    public Optional<CodcontDTO> modificar(Long id, CodcontDTO datos) {
        return repositorioContable.findById(id).map(existente -> {
            Codcont actualizado = convertirAEntidad(datos);
            actualizado.setIdentificador(id);
            return convertirADatos(repositorioContable.save(actualizado));
        });
    }

    public boolean eliminarRegistro(Long id) {
        if (repositorioContable.existsById(id)) {
            repositorioContable.deleteById(id);
            return true;
        }
        return false;
    }
}