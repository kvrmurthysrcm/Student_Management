package com.demo.Student_Management.service;

import com.demo.Student_Management.model.Student;
import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    void saveStudent(Student student);

    void deleteStudent(Long id);
}
