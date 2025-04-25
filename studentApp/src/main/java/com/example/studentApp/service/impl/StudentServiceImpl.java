package com.example.studentApp.service.impl;

import com.example.studentApp.dtos.RegisterDTO;
import com.example.studentApp.dtos.RegisterResponseDTO;
import com.example.studentApp.models.Student;
import com.example.studentApp.repository.StudentRepository;
import com.example.studentApp.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public RegisterResponseDTO registerStudent(RegisterDTO registerDTO){
        if(studentRepository.existsByEmail(registerDTO.getEmail())){
            throw new RuntimeException("Student with email"+registerDTO.getEmail()+"already exists");
        }
        Student student = new Student();
        student.setFirstName(registerDTO.getFirstName());
        student.setLastName(registerDTO.getLastName());
        student.setEmail(registerDTO.getEmail());
        student.setPassword(registerDTO.getPassword());

        Student saveRecord = studentRepository.save(student);
        return new RegisterResponseDTO("Registration is successful", saveRecord.getId());
    }
}
