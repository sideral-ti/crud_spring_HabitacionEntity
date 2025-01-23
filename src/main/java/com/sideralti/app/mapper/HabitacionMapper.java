package com.sideralti.app.mapper;

import com.sideralti.app.model.dto.HabitacionDto;
import com.sideralti.app.model.entity.Habitacion;
import org.springframework.stereotype.Component;

@Component
public class HabitacionMapper {

    public HabitacionDto toDto(Habitacion habitacion) {
        return HabitacionDto.builder()
                .id(habitacion.getId())
                .numero(habitacion.getNumero())
                .nombre(habitacion.getNombre())
                .tipo(habitacion.getTipo())
                .precio(habitacion.getPrecio())
                .capacidad(habitacion.getCapacidad())
                .estado(habitacion.getEstado())
                .piso(habitacion.getPiso())
                .descripcion(habitacion.getDescripcion())
                .imagenPrincipal(habitacion.getImagenPrincipal())
                .imagenes(habitacion.getImagenes())
                .terraza(habitacion.getTerraza())
                .vistaAlMar(habitacion.getVistaAlMar())
                .build();
    }

    public Habitacion toEntity(HabitacionDto dto) {
        return Habitacion.builder()
                .id(dto.id())
                .numero(dto.numero())
                .nombre(dto.nombre())
                .tipo(dto.tipo())
                .precio(dto.precio())
                .capacidad(dto.capacidad())
                .estado(dto.estado())
                .piso(dto.piso())
                .descripcion(dto.descripcion())
                .imagenPrincipal(dto.imagenPrincipal())
                .imagenes(dto.imagenes())
                .terraza(dto.terraza())
                .vistaAlMar(dto.vistaAlMar())
                .build();
    }



}
