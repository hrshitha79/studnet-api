package com.project.studentapi.controller;

import com.project.studentapi.repository.StudentRepository;
import com.project.studentapi.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id){
        Optional<Student> student = studentRepository.findById(id);
        return new ResponseEntity<>(student.get(), HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<String> wish2(@RequestBody Student student){
        studentRepository.save(student);
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }
    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
