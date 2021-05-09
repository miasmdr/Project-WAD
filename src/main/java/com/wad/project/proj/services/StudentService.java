package com.wad.project.proj.services;

import com.wad.project.proj.domain.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);
    List<Student> findAll();
    List<Student> findStudentByName(String name);
    List<Student> findStudentsWithNoCards();
}
