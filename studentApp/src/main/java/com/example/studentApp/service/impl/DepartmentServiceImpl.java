package com.example.studentApp.service.impl;

import com.example.studentApp.dtos.DepartmentResponseDTO;
import com.example.studentApp.repository.DepartmentRepository;
import com.example.studentApp.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentResponseDTO getAllDepartments(long id){
        return departmentRepository.findAll().stream()
                .map(department -> new DepartmentResponseDTO(department.getId(), department.getName(), department.getDescription()));
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentResponseDTO getDepartmentById(long id){
        return departmentRepository.findById(id)
                .map(department -> new DepartmentResponseDTO(department, getId(), department, getDescription()))
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }


}
