package com.example.studentApp.service;

import com.example.studentApp.dtos.RegisterDTO;
import com.example.studentApp.dtos.RegisterResponseDTO;

public interface StudentService {
    RegisterResponseDTO registerStudent(RegisterDTO registerDTO);
}
