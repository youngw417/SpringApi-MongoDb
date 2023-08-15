package com.example.SpringMongoProject.controller;

import com.example.SpringMongoProject.entity.Student;
import com.example.SpringMongoProject.service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@CrossOrigin(origins="*")
public class StudentController {

    @Autowired
    private StudentServices studentServices;

    @PostMapping(value="/save")
    private String saveStudent(@RequestBody Student student) {
        studentServices.saveorUpdate(student);
        return student.get_id();
    }

    @GetMapping(value="/getAll")
    private Iterable<Student> getStudents() {
        return studentServices.listAll();
    }

    @PutMapping(value="/edit/{id}")
    private Student updateStudent(@RequestBody Student student, @PathVariable(name="id") String id) {
        student.set_id(id);
        studentServices.saveorUpdate(student);
        return student;
    }

    @DeleteMapping(value="/delete/{id}")
    private void deleteStudent(@PathVariable(name="id") String _id) {
        studentServices.delete(_id);
    }

    @RequestMapping("/search/{id}")
    private Student getStudent(@PathVariable(name="id") String studentId) {
        return studentServices.getStudentById(studentId);
    }
}
