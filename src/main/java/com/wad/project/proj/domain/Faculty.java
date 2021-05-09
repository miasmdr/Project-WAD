package com.wad.project.proj.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = "students")
@ToString(exclude = "students")
@NoArgsConstructor
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private LocalDate foundedIn;

    public Faculty(String name, LocalDate foundedIn) {
        this.name = name;
        this.foundedIn = foundedIn;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name ="faculty_student",
            joinColumns = @JoinColumn(name="faculty_id"),
            inverseJoinColumns = @JoinColumn(name="student_id"))
    private Set<Student> students = new HashSet<>();

    public void addStudent(Student s){
        students.add(s);
        s.getFaculties().add(this);
    }


}
