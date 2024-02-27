package com.ssemchenko.crud.service;

import com.ssemchenko.crud.dto.TeacherDto;

import java.util.List;

public interface TeacherService {
    TeacherDto findById(int id);
    void deleteById(int id);
    List<TeacherDto> findAll();
    TeacherDto save(TeacherDto teacherDto);
}
