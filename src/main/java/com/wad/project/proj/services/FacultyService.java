package com.wad.project.proj.services;

import com.wad.project.proj.domain.Faculty;

import java.util.List;

public interface FacultyService {
    Faculty save(Faculty f);
    List<Faculty> findAll();
    List<Faculty> findFacultiesByName(String name);
}
