package com.ssemchenko.crud.controller;

import com.ssemchenko.crud.dto.StudentDto;
import com.ssemchenko.crud.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentServiceImpl service;

    @GetMapping("/findAll")
    public List<StudentDto> findAll (){
        return service.findAll();
    }

    @PostMapping("/save")
    public StudentDto save(@RequestBody String name){
        StudentDto studentDto = new StudentDto();
        studentDto.setName(name);
        return service.save(studentDto);
    }

    @GetMapping("/findById")
    public StudentDto findById(@RequestBody Integer id){
        return service.findById(id);
    }
    @DeleteMapping("/delete")
    public void deleteById(@RequestBody Integer id){
        service.deleteById(id);
    }
}
