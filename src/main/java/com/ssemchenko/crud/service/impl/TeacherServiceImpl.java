package com.ssemchenko.crud.service.impl;

import com.ssemchenko.crud.dto.TeacherDto;
import com.ssemchenko.crud.entity.Teacher;
import com.ssemchenko.crud.repository.TeacherRepository;
import com.ssemchenko.crud.service.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRepository repository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public TeacherDto findById(int id) {
        return modelMapper.map(repository.findById(id), TeacherDto.class);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<TeacherDto> findAll() {
        List<Teacher> list = repository.findAll();
        return list.stream().map(teacher -> modelMapper.map(teacher, TeacherDto.class)).collect(Collectors.toList());
    }

    @Override
    public TeacherDto save(TeacherDto teacherDto) {
        Teacher teacher = modelMapper.map(teacherDto, Teacher.class);
        Teacher saved = repository.save(teacher);
        return modelMapper.map(saved, TeacherDto.class);
    }
}
