package com.example.demo.entity;
import jakarta.persistence.*;
@Entity
@Table
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long facultyId;

    private String facultyName;

    private String facultyDesig;

    public Faculty() {
    }

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyDesig() {
        return facultyDesig;
    }

    public void setFacultyDesig(String facultyDesig) {
        this.facultyDesig = facultyDesig;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId=" + facultyId +
                ", facultyName='" + facultyName + '\'' +
                ", facultyDesig='" + facultyDesig + '\'' +
                '}';
    }

}
