package com.ssemchenko.crud.service;

import com.ssemchenko.crud.dto.FacultyDto;
import com.ssemchenko.crud.entity.Faculty;

import java.util.List;

public interface FacultyService {
    FacultyDto findById(int id);
    void deleteById(int id);
    List<FacultyDto> findAll();
    FacultyDto save(FacultyDto facultydto);
}
