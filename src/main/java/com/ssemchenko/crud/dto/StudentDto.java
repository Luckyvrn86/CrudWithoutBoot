package com.ssemchenko.crud.dto;

import java.util.Objects;

public class StudentDto {
    private int id;
    private String name;
    private FacultyDto facultyDto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FacultyDto getFacultyDto() {
        return facultyDto;
    }

    public void setFacultyDto(FacultyDto facultyDto) {
        this.facultyDto = facultyDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDto that = (StudentDto) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", facultyDto=" + facultyDto +
                '}';
    }
}
