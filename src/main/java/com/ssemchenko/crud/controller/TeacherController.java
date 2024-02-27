package com.ssemchenko.crud.controller;

import com.ssemchenko.crud.dto.TeacherDto;
import com.ssemchenko.crud.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherServiceImpl service;

    @GetMapping("/findAll")
    public List<TeacherDto> findAll (){
        return service.findAll();
    }

    @PostMapping("/save")
    public TeacherDto save(@RequestBody String name){
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setName(name);
        return service.save(teacherDto);
    }

    @GetMapping("/findById")
    public TeacherDto findById(@RequestBody Integer id){
        return service.findById(id);
    }
    @DeleteMapping("/delete")
    public void deleteById(@RequestBody Integer id){
        service.deleteById(id);
    }
}
