package com.practica.crud.service;

import com.practica.crud.dto.BajaDTO;
import com.practica.crud.model.Baja;
import com.practica.crud.repository.BajaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BajaService {

    private final BajaRepository bajaRepository;

    public BajaService(BajaRepository bajaRepository) {
        this.bajaRepository = bajaRepository;
    }

    private BajaDTO toDTO(Baja entidad) {
        BajaDTO dto = new BajaDTO();
        dto.setId(entidad.getId());
        dto.setCodigo(entidad.getCodigo());
        dto.setNombreElemento(entidad.getNombreElemento());
        dto.setMotivo(entidad.getMotivo());
        dto.setFechaBaja(entidad.getFechaBaja());
        dto.setEstado(entidad.getEstado());
        dto.setActivo(entidad.getActivo());
        return dto;
    }

    private Baja toEntity(BajaDTO dto) {
        Baja entidad = new Baja();
        entidad.setId(dto.getId());
        entidad.setCodigo(dto.getCodigo());
        entidad.setNombreElemento(dto.getNombreElemento());
        entidad.setMotivo(dto.getMotivo());
        entidad.setFechaBaja(dto.getFechaBaja());
        entidad.setEstado(dto.getEstado());
        entidad.setActivo(dto.getActivo());
        return entidad;
    }

    public List<BajaDTO> listar() {
        return bajaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<BajaDTO> buscarPorId(Long id) {
        return bajaRepository.findById(id).map(this::toDTO);
    }

    public BajaDTO crear(BajaDTO dto) {
        return toDTO(bajaRepository.save(toEntity(dto)));
    }

    public Optional<BajaDTO> actualizar(Long id, BajaDTO dto) {
        return bajaRepository.findById(id).map(existente -> {
            Baja actualizado = toEntity(dto);
            actualizado.setId(id);
            return toDTO(bajaRepository.save(actualizado));
        });
    }

    public boolean eliminar(Long id) {
        if (bajaRepository.existsById(id)) {
            bajaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}