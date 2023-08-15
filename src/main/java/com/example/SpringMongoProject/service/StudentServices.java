package com.example.SpringMongoProject.service;

import com.example.SpringMongoProject.entity.Student;
import com.example.SpringMongoProject.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServices {

    @Autowired
    private StudentRepo studentRepo;
    public void saveorUpdate(Student student) {
        studentRepo.save(student);
    }

    public Iterable<Student> listAll() {
        return this.studentRepo.findAll();
    }

    public void delete(String id) {
        studentRepo.deleteById(id);
    }

    public Student getStudentById(String studentId) {
        return studentRepo.findById(studentId).get();
    }
}
