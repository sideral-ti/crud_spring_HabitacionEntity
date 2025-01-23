package com.sideralti.app.service;

import com.sideralti.app.model.dto.HabitacionDto;

import java.util.List;

public interface HabitacionService {

    List<HabitacionDto> findAll();
    HabitacionDto findById(Long id);
    HabitacionDto save(HabitacionDto dto);
    void deleteById(Long id);
    HabitacionDto update(Long id, HabitacionDto dto);
    List<HabitacionDto> saveAll(List<HabitacionDto> dtos);
    long count();



}
