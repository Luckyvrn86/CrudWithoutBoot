package com.ssemchenko.crud.controller;

import com.ssemchenko.crud.dto.FacultyDto;
import com.ssemchenko.crud.service.impl.FacultyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    FacultyServiceImpl service;

    @GetMapping("/findAll")
    public List<FacultyDto> findAll (){
        return service.findAll();
    }

    @PostMapping("/save")
    public FacultyDto save(@RequestBody String name){
        FacultyDto facultyDto = new FacultyDto();
        facultyDto.setName(name);
        return service.save(facultyDto);
    }

    @GetMapping("/findById")
    public FacultyDto findById(@RequestBody Integer id){
        return service.findById(id);
    }
    @DeleteMapping("/delete")
    public void deleteById(@RequestBody Integer id){
        service.deleteById(id);
    }

}
