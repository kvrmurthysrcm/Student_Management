package com.demo.Student_Management.controller;

import com.demo.Student_Management.model.Student;
import com.demo.Student_Management.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String listStudents(Model model)
    {
        System.out.println("Inside listStudents()....");
        List<Student> students
                = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students/list.html"; // This should match with the actual template path
    }

    @GetMapping("/add")
    public String showAddForm(Model model)
    {
        System.out.println("Inside showAddForm()....");
        model.addAttribute("student", new Student());
        return "students/add.html";
    }

    // @PostMapping("/add")
    @PostMapping("/add")
    public String
    addStudent(@ModelAttribute("student") Student student)
    {
        System.out.println("Inside addStudent()....");
        studentService.saveStudent(student);
        return "redirect:/students/add.html";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id,
                               Model model)
    {
        System.out.println("Inside showEditForm()....");
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "students/edit.html";
    }

    @PostMapping("/edit/{id}")
    public String
    editStudent(@PathVariable Long id,
                @ModelAttribute("student") Student student)
    {
        studentService.saveStudent(student);
        return "redirect:/students/list.html";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id)
    {
        studentService.deleteStudent(id);
        return "redirect:/students/list.html";
    }
}