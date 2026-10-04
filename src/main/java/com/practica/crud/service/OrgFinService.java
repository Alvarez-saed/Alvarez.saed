package com.practica.crud.service;

import com.practica.crud.dto.OrgFinDTO;
import com.practica.crud.model.OrgFin;
import com.practica.crud.repository.OrgFinRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrgFinService {

    private final OrgFinRepository orgFinRepository;

    public OrgFinService(OrgFinRepository orgFinRepository) {
        this.orgFinRepository = orgFinRepository;
    }

    private OrgFinDTO convertirADTO(OrgFin entidad) {
        OrgFinDTO dto = new OrgFinDTO();
        dto.setCodigo(entidad.getCodigo());
        dto.setClave(entidad.getClave());
        dto.setNombre(entidad.getNombre());
        dto.setNivel(entidad.getNivel());
        dto.setActivo(entidad.isActivo());
        return dto;
    }

    private OrgFin convertirAEntidad(OrgFinDTO dto) {
        OrgFin registro = new OrgFin();
        registro.setCodigo(dto.getCodigo());
        registro.setClave(dto.getClave());
        registro.setNombre(dto.getNombre());
        registro.setNivel(dto.getNivel());
        registro.setActivo(dto.isActivo());
        return registro;
    }

    public List<OrgFinDTO> listarTodos() {
        return orgFinRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public Optional<OrgFinDTO> buscarPorCodigo(Long id) {
        return orgFinRepository.findById(id).map(this::convertirADTO);
    }

    public OrgFinDTO registrar(OrgFinDTO datos) {
        return convertirADTO(orgFinRepository.save(convertirAEntidad(datos)));
    }

    public Optional<OrgFinDTO> modificar(Long id, OrgFinDTO datos) {
        return orgFinRepository.findById(id).map(existente -> {
            OrgFin actualizado = convertirAEntidad(datos);
            actualizado.setCodigo(id);
            return convertirADTO(orgFinRepository.save(actualizado));
        });
    }

    public boolean eliminarRegistro(Long id) {
        if (orgFinRepository.existsById(id)) {
            orgFinRepository.deleteById(id);
            return true;
        }
        return false;
    }
}