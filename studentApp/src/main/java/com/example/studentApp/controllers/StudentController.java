package com.example.studentApp.controllers;

import com.example.studentApp.dtos.RegisterDTO;
import com.example.studentApp.dtos.RegisterResponseDTO;
import com.example.studentApp.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    ResponseEntity<RegisterResponseDTO> register(@RequestBody RegisterDTO registerDTO){
        RegisterResponseDTO registerStudent = studentService.registerStudent(registerDTO);
        return new ResponseEntity<>(registerStudent, HttpStatus.CREATED);
    }
}
