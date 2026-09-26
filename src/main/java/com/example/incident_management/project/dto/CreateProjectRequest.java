package com.example.incident_management.project.dto;

import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data @NoArgsConstructor
public class CreateProjectRequest {
    @NotBlank(message="Nama wajib diisi")
    @Size(max = 256, message = "Nama maksimal 256 karakter")
    private String name;

    @NotBlank(message="Deskripsi wajib diisi")
    private String description;
}
