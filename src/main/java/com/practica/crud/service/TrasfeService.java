package com.practica.crud.service;

import com.practica.crud.dto.TrasfeDTO;
import com.practica.crud.model.Trasfe;
import com.practica.crud.repository.TrasfeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrasfeService {

    private final TrasfeRepository trasfeRepository;

    public TrasfeService(TrasfeRepository trasfeRepository) {
        this.trasfeRepository = trasfeRepository;
    }

    private TrasfeDTO convertirADTO(Trasfe entidad) {
        TrasfeDTO dto = new TrasfeDTO();
        dto.setCodigo(entidad.getCodigo());
        dto.setClaveTraslado(entidad.getClaveTraslado());
        dto.setOrigen(entidad.getOrigen());
        dto.setDestino(entidad.getDestino());
        dto.setMontoMovimiento(entidad.getMontoMovimiento());
        dto.setFechaOperacion(entidad.getFechaOperacion());
        dto.setConfirmado(entidad.isConfirmado());
        return dto;
    }

    private Trasfe convertirAEntidad(TrasfeDTO dto) {
        Trasfe registro = new Trasfe();
        registro.setCodigo(dto.getCodigo());
        registro.setClaveTraslado(dto.getClaveTraslado());
        registro.setOrigen(dto.getOrigen());
        registro.setDestino(dto.getDestino());
        registro.setMontoMovimiento(dto.getMontoMovimiento());
        registro.setFechaOperacion(dto.getFechaOperacion());
        registro.setConfirmado(dto.isConfirmado());
        return registro;
    }

    public List<TrasfeDTO> listarTodo() {
        return trasfeRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public Optional<TrasfeDTO> buscarPorCodigo(Long id) {
        return trasfeRepository.findById(id).map(this::convertirADTO);
    }

    public TrasfeDTO registrarTraslado(TrasfeDTO datos) {
        return convertirADTO(trasfeRepository.save(convertirAEntidad(datos)));
    }

    public Optional<TrasfeDTO> modificarTraslado(Long id, TrasfeDTO datos) {
        return trasfeRepository.findById(id).map(existente -> {
            Trasfe actualizado = convertirAEntidad(datos);
            actualizado.setCodigo(id);
            return convertirADTO(trasfeRepository.save(actualizado));
        });
    }

    public boolean eliminarRegistro(Long id) {
        if (trasfeRepository.existsById(id)) {
            trasfeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}