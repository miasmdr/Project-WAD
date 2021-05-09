package com.wad.project.proj.services;

import com.wad.project.proj.domain.Student;
import com.wad.project.proj.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository  studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findStudentByName(String name) {
        return studentRepository.findStudentByName(name);
    }

    @Override
    public List<Student> findStudentsWithNoCards() {
        return studentRepository.findStudentsWithNoCards();
    }
}
