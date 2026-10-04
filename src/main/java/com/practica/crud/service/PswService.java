package com.practica.crud.service;

import com.practica.crud.dto.PswDTO;
import com.practica.crud.model.Psw;
import com.practica.crud.repository.PswRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PswService {

    private final PswRepository pswRepository;

    public PswService(PswRepository pswRepository) {
        this.pswRepository = pswRepository;
    }

    private PswDTO convertirADTO(Psw entidad) {
        PswDTO dto = new PswDTO();
        dto.setCodigo(entidad.getCodigo());
        dto.setUsuario(entidad.getUsuario());
        dto.setClaveAcceso(entidad.getClaveAcceso());
        dto.setUltimaModificacion(entidad.getUltimaModificacion());
        dto.setVigente(entidad.isVigente());
        return dto;
    }

    private Psw convertirAEntidad(PswDTO dto) {
        Psw registro = new Psw();
        registro.setCodigo(dto.getCodigo());
        registro.setUsuario(dto.getUsuario());
        registro.setClaveAcceso(dto.getClaveAcceso());
        registro.setUltimaModificacion(dto.getUltimaModificacion());
        registro.setVigente(dto.isVigente());
        return registro;
    }

    public List<PswDTO> listarTodo() {
        return pswRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public Optional<PswDTO> buscarPorCodigo(Long id) {
        return pswRepository.findById(id).map(this::convertirADTO);
    }

    public PswDTO registrar(PswDTO datos) {
        return convertirADTO(pswRepository.save(convertirAEntidad(datos)));
    }

    public Optional<PswDTO> modificar(Long id, PswDTO datos) {
        return pswRepository.findById(id).map(existente -> {
            Psw actualizado = convertirAEntidad(datos);
            actualizado.setCodigo(id);
            return convertirADTO(pswRepository.save(actualizado));
        });
    }

    public boolean eliminarRegistro(Long id) {
        if (pswRepository.existsById(id)) {
            pswRepository.deleteById(id);
            return true;
        }
        return false;
    }
}