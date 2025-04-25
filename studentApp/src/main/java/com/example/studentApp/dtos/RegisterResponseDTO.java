package com.example.studentApp.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterResponseDTO {
    private String message;
    private Long studentId;

    public RegisterResponseDTO(String message, Long studentId) {
        this.message = message;
        this.studentId = studentId;
    }
}
