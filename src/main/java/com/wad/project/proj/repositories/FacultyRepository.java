package com.wad.project.proj.repositories;

import com.wad.project.proj.domain.Faculty;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FacultyRepository extends CrudRepository<Faculty,Long> {
    List<Faculty> findAll();
    List<Faculty> findFacultiesByName(String name);
}
