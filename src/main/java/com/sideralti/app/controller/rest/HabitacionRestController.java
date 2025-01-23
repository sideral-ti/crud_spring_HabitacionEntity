package com.sideralti.app.controller.rest;

import com.sideralti.app.model.dto.HabitacionDto;
import com.sideralti.app.service.HabitacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/habitaciones")
@RequiredArgsConstructor
public class HabitacionRestController {

    private final HabitacionService habitacionService;


    @GetMapping("/{id}")
    public ResponseEntity<HabitacionDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(habitacionService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<HabitacionDto>> findAll() {
        return ResponseEntity.ok(habitacionService.findAll());
    }

    @PostMapping
    public ResponseEntity<HabitacionDto> save(@Valid @RequestBody HabitacionDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(habitacionService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HabitacionDto> update(@PathVariable Long id, @Valid @RequestBody HabitacionDto dto) {
        return ResponseEntity.ok(habitacionService.update(id, dto));
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<HabitacionDto>> saveAll(@Valid @RequestBody List<HabitacionDto> dtos) {
        return ResponseEntity.status(HttpStatus.CREATED).body(habitacionService.saveAll(dtos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        habitacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(habitacionService.count());
    }

}
