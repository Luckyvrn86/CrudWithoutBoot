package com.ssemchenko.crud.service;

import com.ssemchenko.crud.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto findById(int id);
    void deleteById(int id);
    List<StudentDto> findAll();
    StudentDto save(StudentDto studentDto);
}
