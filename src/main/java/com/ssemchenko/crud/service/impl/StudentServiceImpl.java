package com.ssemchenko.crud.service.impl;

import com.ssemchenko.crud.dto.StudentDto;
import com.ssemchenko.crud.entity.Student;
import com.ssemchenko.crud.repository.StudentRepository;
import com.ssemchenko.crud.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository repository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public StudentDto findById(int id) {
        return modelMapper.map(repository.findById(id), StudentDto.class);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<StudentDto> findAll() {
        List<Student> list = repository.findAll();
        return list.stream().map(student -> modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
    }

    @Override
    public StudentDto save(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        Student saved = repository.save(student);
        return modelMapper.map(saved, StudentDto.class);
    }
}
