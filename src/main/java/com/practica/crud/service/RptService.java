package com.practica.crud.service;

import com.practica.crud.dto.RptDTO;
import com.practica.crud.model.Rpt;
import com.practica.crud.repository.RptRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RptService {

    private final RptRepository rptRepository;

    public RptService(RptRepository rptRepository) {
        this.rptRepository = rptRepository;
    }

    private RptDTO convertirADTO(Rpt entidad) {
        RptDTO dto = new RptDTO();
        dto.setCodigo(entidad.getCodigo());
        dto.setNombreReporte(entidad.getNombreReporte());
        dto.setTipo(entidad.getTipo());
        dto.setDescripcion(entidad.getDescripcion());
        dto.setAutor(entidad.getAutor());
        dto.setActivo(entidad.isActivo());
        return dto;
    }

    private Rpt convertirAEntidad(RptDTO dto) {
        Rpt registro = new Rpt();
        registro.setCodigo(dto.getCodigo());
        registro.setNombreReporte(dto.getNombreReporte());
        registro.setTipo(dto.getTipo());
        registro.setDescripcion(dto.getDescripcion());
        registro.setAutor(dto.getAutor());
        registro.setActivo(dto.isActivo());
        return registro;
    }

    public List<RptDTO> listarTodo() {
        return rptRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public Optional<RptDTO> buscarPorCodigo(Long id) {
        return rptRepository.findById(id).map(this::convertirADTO);
    }

    public RptDTO registrar(RptDTO datos) {
        return convertirADTO(rptRepository.save(convertirAEntidad(datos)));
    }

    public Optional<RptDTO> modificar(Long id, RptDTO datos) {
        return rptRepository.findById(id).map(existente -> {
            Rpt actualizado = convertirAEntidad(datos);
            actualizado.setCodigo(id);
            return convertirADTO(rptRepository.save(actualizado));
        });
    }

    public boolean eliminarRegistro(Long id) {
        if (rptRepository.existsById(id)) {
            rptRepository.deleteById(id);
            return true;
        }
        return false;
    }
}