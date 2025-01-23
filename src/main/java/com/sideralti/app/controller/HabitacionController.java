package com.sideralti.app.controller;

import com.sideralti.app.model.dto.HabitacionDto;
import com.sideralti.app.service.HabitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/habitaciones")
@RequiredArgsConstructor
public class HabitacionController {

    private final HabitacionService habitacionService;

    @GetMapping
    public String home(Model model) {
        //List<HabitacionDto> habitaciones = habitacionService.findAll();
        model.addAttribute("title", "Bienvenido a Hotel Sideral");
        return "index";
    }


    @GetMapping("/form")
    public String mostrarFormulario() {
        return "form";
    }

    @GetMapping("/form2")
    public String mostrarFormulario2() {
        return "form2";
    }

    @GetMapping("/lista")
    public String getAllHabitaciones(Model model) {
        List<HabitacionDto> habitaciones = habitacionService.findAll();
        model.addAttribute("habitaciones", habitaciones);
        return "lista";
    }

    @GetMapping("/{id}")
    public String getHabitacionById(@PathVariable Long id, Model model) {
        HabitacionDto habitacion = habitacionService.findById(id);
        model.addAttribute("habitacion", habitacion);
        return "detalles";
    }

    @PostMapping
    public ResponseEntity<HabitacionDto> createHabitacion(@RequestBody HabitacionDto dto) {
        return ResponseEntity.ok(habitacionService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabitacion(@PathVariable Long id) {
        habitacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
