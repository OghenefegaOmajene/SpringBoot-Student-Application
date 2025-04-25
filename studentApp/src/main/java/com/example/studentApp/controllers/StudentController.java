package com.example.studentApp.controllers;

import com.example.studentApp.dtos.RegisterDTO;
import com.example.studentApp.dtos.RegisterResponseDTO;
import com.example.studentApp.service.StudentService;
import io.swagger.v3.oas.annotations.tags.*;
import io.swagger.v3.oas.annotations.*;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Tag(name = "Auth")
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(summary = "This is for student registration")
    @PostMapping
    ResponseEntity<?> register(@Valid @RequestBody RegisterDTO registerDTO, BindingResult result){
        RegisterResponseDTO registerStudent = studentService.registerStudent(registerDTO);
        if(result.hasErrors()){
            List<String> errors = result.getFieldErrors().stream().map(error->error.getField()+": "+ error.getDefaultMessage()).collect(Collectors.toList());
            return new ResponseEntity<>(Map.of("errors",errors), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(registerStudent, HttpStatus.CREATED);
    }
}
