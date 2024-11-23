package com.example.demo.service;
import com.example.demo.entity.Faculty;

import java.util.List;

public interface FacultyService {
    Faculty save(Faculty faculty);

    List<Faculty> fetchAll();

    Faculty fetchById(Long facultyId);

    void deleteByFacultyId(Long facultyId);

    List<Faculty> fetchByFacultyName(String name);
    List<Faculty> fetchByFacultyDesig(String desig);
}
