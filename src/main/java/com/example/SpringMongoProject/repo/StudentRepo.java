package com.example.SpringMongoProject.repo;

import com.example.SpringMongoProject.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, String> {
}
