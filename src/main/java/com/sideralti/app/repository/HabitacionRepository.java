package com.sideralti.app.repository;

import com.sideralti.app.model.entity.Habitacion;
import com.sideralti.app.model.enums.EstadoHabitacion;
import com.sideralti.app.model.enums.TipoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {

    Optional<Habitacion> findByNumero(String numero);
    List<Habitacion> findByTipo(TipoHabitacion tipo);
    List<Habitacion> findByEstado(EstadoHabitacion estado);


}
