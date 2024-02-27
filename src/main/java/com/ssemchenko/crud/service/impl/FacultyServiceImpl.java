package com.ssemchenko.crud.service.impl;

import com.ssemchenko.crud.dto.FacultyDto;
import com.ssemchenko.crud.entity.Faculty;
import com.ssemchenko.crud.repository.FacultyRepository;
import com.ssemchenko.crud.service.FacultyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    FacultyRepository repository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public FacultyDto findById(int id) {
        return modelMapper.map(repository.findById(id), FacultyDto.class);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<FacultyDto> findAll() {
        List<Faculty> list = repository.findAll();
        return list.stream().map(faculty -> modelMapper.map(faculty, FacultyDto.class)).collect(Collectors.toList());
    }

    @Override
    public FacultyDto save(FacultyDto facultyDto) {
        Faculty faculty = modelMapper.map(facultyDto, Faculty.class);
        Faculty saved = repository.save(faculty);
        return modelMapper.map(saved, FacultyDto.class);
    }
}
