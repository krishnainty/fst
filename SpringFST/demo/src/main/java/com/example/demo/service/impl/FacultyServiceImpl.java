package com.example.demo.service.impl;

import com.example.demo.entity.Faculty;
import com.example.demo.repository.FacultyRepository;
import com.example.demo.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public Faculty save(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public List<Faculty> fetchAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty fetchById(Long facultyId) {
        return facultyRepository.findById(facultyId).get();
    }

    @Override
    public void deleteByFacultyId(Long facultyId) {
        facultyRepository.deleteById(facultyId);
    }

    @Override
    public List<Faculty> fetchByFacultyName(String name) {
        return facultyRepository.findByFacultyName(name);
    }
    @Override
    public List<Faculty> fetchByFacultyDesig(String desig) {
        return facultyRepository.findByFacultyDesig(desig);
    }
}
