package com.wad.project.proj.bootstrap;

import com.wad.project.proj.domain.Address;
import com.wad.project.proj.domain.Card;
import com.wad.project.proj.domain.Faculty;
import com.wad.project.proj.domain.Student;
import com.wad.project.proj.services.FacultyService;
import com.wad.project.proj.services.StudentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final StudentService studentService;
    private final FacultyService facultyService;

    public DataLoader(StudentService studentService, @Qualifier("facultyServiceEm") FacultyService facultyService) {
        this.studentService = studentService;
        this.facultyService = facultyService;
    }

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student("John");
        Address a1= new Address("Bucuresti");
        s1.setAddress(a1);
        Card c1 = new Card("123");
        Card c2 = new Card("234");
        s1.addCard(c1);
        s1.addCard(c2);


        Student s2 = new Student("Mary");
        Address a2= new Address("Ploiesti");
        s2.setAddress(a2);



        Faculty fils = new Faculty("FILS", LocalDate.of(2001,1,1));
        fils.addStudent(s1);
        facultyService.save(fils);

        Faculty sels = new Faculty("SELS", LocalDate.of(1999,1,1));
        sels.addStudent(s2);
        facultyService.save(sels);

        System.out.println(facultyService.findAll());
        System.out.println("-------------------------------------------");
        System.out.println(facultyService.findFacultiesByName("FILS"));
        System.out.println("-------------------------------------------");
        System.out.println(facultyService.findFacultiesByName("FILS").get(0).getStudents());
        System.out.println("-------------------------------------------");
        System.out.println("All students");
        System.out.println(studentService.findAll());
        System.out.println("-------------------------------------------");
        System.out.println("Students named john");
        System.out.println(studentService.findStudentByName("John"));
        System.out.println("-------------------------------------------");
        System.out.println("Students with no cards");
        System.out.println(studentService.findStudentsWithNoCards());
        System.out.println("-------------------------------------------");
        System.out.println("Cards of the student");
        System.out.println(studentService.findStudentByName("John").get(0).getCards());
    }
}
