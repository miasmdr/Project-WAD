package com.wad.project.proj.repositories;

import com.wad.project.proj.domain.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Long> {
    /**
     * Gets all students
     * @return List of students
     */
    @Query("SELECT s FROM Student s")
    List<Student> findAll();


    /**
     * Gets all students with given name
     * @param name
     * @return List of students with name
     */
    @Query("SELECT s FROM Student s WHERE s.name = :name")
    List<Student> findStudentByName(String name);

    /**
     * Gets list of students with no cards
     * @return List of students with no cards
     */
    @Query("SELECT s FROM Student s WHERE s.cards IS EMPTY")
    List<Student> findStudentsWithNoCards();


}
