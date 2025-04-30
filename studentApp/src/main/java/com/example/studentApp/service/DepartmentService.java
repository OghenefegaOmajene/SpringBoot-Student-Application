package com.example.studentApp.service;

import com.example.studentApp.dtos.DepartmentDTO;
import com.example.studentApp.dtos.DepartmentResponseDTO;

import java.util.List;

public interface DepartmentService {
    List<DepartmentResponseDTO> getAllDepartments();
    DepartmentResponseDTO getDepartmentById(long id);
    DepartmentResponseDTO createDepartment (DepartmentDTO departmentDTO);
    DepartmentResponseDTO updateDepartment (long id, DepartmentDTO departmentDTO);
    void deleteDepartment(long id);

    List<DepartmentResponseDTO> searchDepartments(String name);
}
