package com.sideralti.app.model.dto;

import com.sideralti.app.model.enums.EstadoHabitacion;
import com.sideralti.app.model.enums.TipoHabitacion;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record HabitacionDto(
        Long id,
        String numero,
        String nombre,
        TipoHabitacion tipo,
        BigDecimal precio,
        Integer capacidad,
        EstadoHabitacion estado,
        Integer piso,
        String descripcion,
        String imagenPrincipal,
        List<String> imagenes,
        Boolean terraza,
        Boolean vistaAlMar
) {}