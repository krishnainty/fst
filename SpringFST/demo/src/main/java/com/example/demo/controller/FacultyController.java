package com.example.demo.controller;

import com.example.demo.entity.Faculty;
import com.example.demo.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @PostMapping("/save")
    public Faculty save(@RequestBody Faculty faculty)
    {
        return facultyService.save(faculty);
    }

    @GetMapping("/fetchAll")
    public List<Faculty> fetchAll()
    {
        return facultyService.fetchAll();
    }

    @GetMapping("/fetchById/{id}")
    public Faculty fetchById(@PathVariable("id") Long facultyId)
    {
        return facultyService.fetchById(facultyId);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteByFacultyId(@PathVariable("id") Long facultyId)
    {
        facultyService.deleteByFacultyId(facultyId);
        return "Success";
    }

//    @PostMapping("/fetchByFacultyName")
//    public List<Faculty> fetchByFacultyName(@RequestBody String name){
//        return facultyService.fetchByFacultyName(name);
//    }

    @PostMapping("/fetchByFacultyName")
    public List<Faculty> fetchByFacultyName(@RequestParam("name") String name){
        return facultyService.fetchByFacultyName(name);
    }

    @PostMapping("/fetchByFacultyDesig")
    public List<Faculty> fetchByFacultyDesig(@RequestParam("desig") String desig){
        return facultyService.fetchByFacultyDesig(desig);
    }
}
