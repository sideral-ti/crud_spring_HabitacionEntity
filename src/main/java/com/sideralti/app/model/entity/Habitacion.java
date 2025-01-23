package com.sideralti.app.model.entity;

import com.sideralti.app.model.enums.EstadoHabitacion;
import com.sideralti.app.model.enums.TipoHabitacion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "habitaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numero;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoHabitacion tipo;

    @Column(nullable = false)
    private BigDecimal precio;

    @Column(nullable = false)
    private Integer capacidad;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoHabitacion estado;

    @Column(nullable = false)
    private Integer piso;

    @Column(length = 1000)
    private String descripcion;

    @Column(name = "imagen_principal", length = 500)
    private String imagenPrincipal;

    @ElementCollection
    @CollectionTable(name = "habitacion_imagenes", joinColumns = @JoinColumn(name = "habitacion_id"))
    @Column(name = "imagen_url", length = 500)
    private List<String> imagenes;


    private Boolean terraza;
    private Boolean vistaAlMar;
}