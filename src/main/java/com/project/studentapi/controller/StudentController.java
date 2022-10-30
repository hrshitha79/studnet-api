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
        if(student.isPresent()){
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
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
    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        Optional<Student> s = studentRepository.findById(id);
        if (s.isPresent()){
            studentRepository.deleteById(id);
        }
        return new ResponseEntity<>("Record deleted", HttpStatus.OK);
    }
    @PutMapping("/student")
    public ResponseEntity<String> updateStudent(@RequestBody Student student){
        Optional<Student> savedStudent  = studentRepository.findById(student.getStd_rollno());
        if (savedStudent.isPresent()){
            Student newStudent = savedStudent.get();
            newStudent.setStd_rollno(student.getStd_rollno());
            newStudent.setStd_name(student.getStd_name());
            studentRepository.save(newStudent);
        }
        return new ResponseEntity<>("RECORD UPDATED", HttpStatus.OK);
    }
}
