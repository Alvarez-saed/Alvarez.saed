package com.practica.crud.service;

import com.practica.crud.dto.OrgUsrDTO;
import com.practica.crud.model.OrgUsr;
import com.practica.crud.repository.OrgUsrRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrgUsrService {

    private final OrgUsrRepository orgUsrRepository;

    public OrgUsrService(OrgUsrRepository orgUsrRepository) {
        this.orgUsrRepository = orgUsrRepository;
    }

    private OrgUsrDTO convertirADTO(OrgUsr entidad) {
        OrgUsrDTO dto = new OrgUsrDTO();
        dto.setCodigo(entidad.getCodigo());
        dto.setUsuario(entidad.getUsuario());
        dto.setNombreCompleto(entidad.getNombreCompleto());
        dto.setCargo(entidad.getCargo());
        dto.setCorreo(entidad.getCorreo());
        dto.setActivo(entidad.isActivo());
        return dto;
    }

    private OrgUsr convertirAEntidad(OrgUsrDTO dto) {
        OrgUsr reg = new OrgUsr();
        reg.setCodigo(dto.getCodigo());
        reg.setUsuario(dto.getUsuario());
        reg.setNombreCompleto(dto.getNombreCompleto());
        reg.setCargo(dto.getCargo());
        reg.setCorreo(dto.getCorreo());
        reg.setActivo(dto.isActivo());
        return reg;
    }

    public List<OrgUsrDTO> listarTodo() {
        return orgUsrRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public Optional<OrgUsrDTO> buscarPorCodigo(Long id) {
        return orgUsrRepository.findById(id).map(this::convertirADTO);
    }

    public OrgUsrDTO registrar(OrgUsrDTO datos) {
        return convertirADTO(orgUsrRepository.save(convertirAEntidad(datos)));
    }

    public Optional<OrgUsrDTO> modificar(Long id, OrgUsrDTO datos) {
        return orgUsrRepository.findById(id).map(existente -> {
            OrgUsr actual = convertirAEntidad(datos);
            actual.setCodigo(id);
            return convertirADTO(orgUsrRepository.save(actual));
        });
    }

    public boolean borrar(Long id) {
        if (orgUsrRepository.existsById(id)) {
            orgUsrRepository.deleteById(id);
            return true;
        }
        return false;
    }
}