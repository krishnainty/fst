package com.cse.FSTSpring4.repository;
import com.cse.FSTSpring4.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
