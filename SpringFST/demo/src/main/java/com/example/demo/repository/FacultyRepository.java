package com.example.demo.repository;
import com.example.demo.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface FacultyRepository extends JpaRepository<Faculty,Long> {
    List<Faculty> findByFacultyName(String name);
    List<Faculty> findByFacultyDesig(String desig);
}
