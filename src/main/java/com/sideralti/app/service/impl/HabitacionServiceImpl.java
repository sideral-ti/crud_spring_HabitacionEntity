package com.sideralti.app.service.impl;

import com.sideralti.app.exceptions.ResourceNotFoundException;
import com.sideralti.app.mapper.HabitacionMapper;
import com.sideralti.app.model.dto.HabitacionDto;
import com.sideralti.app.model.entity.Habitacion;
import com.sideralti.app.repository.HabitacionRepository;
import com.sideralti.app.service.HabitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HabitacionServiceImpl implements HabitacionService {

    private final HabitacionRepository habitacionRepository;
    private final HabitacionMapper habitacionMapper;

    public List<HabitacionDto> findAll() {
        return habitacionRepository.findAll()
                .stream()
                .map(habitacionMapper::toDto)
                .collect(Collectors.toList());
    }

    public HabitacionDto findById(Long id) {
        Habitacion habitacion = habitacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habitación no encontrada"));
        return habitacionMapper.toDto(habitacion);
    }

    public HabitacionDto save(HabitacionDto dto) {
        Habitacion habitacion = habitacionMapper.toEntity(dto);
        return habitacionMapper.toDto(habitacionRepository.save(habitacion));
    }



    @Transactional
    public HabitacionDto update(Long id, HabitacionDto dto) {
        Habitacion existente = habitacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habitación no encontrada"));

        existente.setNumero(dto.numero());
        existente.setNombre(dto.nombre());
        existente.setTipo(dto.tipo());
        existente.setPrecio(dto.precio());
        existente.setCapacidad(dto.capacidad());
        existente.setEstado(dto.estado());
        existente.setPiso(dto.piso());
        existente.setDescripcion(dto.descripcion());
        existente.setImagenPrincipal(dto.imagenPrincipal());
        existente.setImagenes(dto.imagenes());
        existente.setTerraza(dto.terraza());
        existente.setVistaAlMar(dto.vistaAlMar());

        return habitacionMapper.toDto(habitacionRepository.save(existente));
    }

    @Transactional
    public List<HabitacionDto> saveAll(List<HabitacionDto> dtos) {
        List<Habitacion> habitaciones = dtos.stream()
                .map(habitacionMapper::toEntity)
                .collect(Collectors.toList());
        return habitacionRepository.saveAll(habitaciones).stream()
                .map(habitacionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteById(Long id) {
        if (!habitacionRepository.existsById(id)) {
            throw new ResourceNotFoundException("Habitación no encontrada");
        }
        habitacionRepository.deleteById(id);
    }

    public long count() {
        return habitacionRepository.count();
    }

}
