package com.example.incident_management.project.controller;

import java.util.List;
import java.util.UUID;

import com.example.incident_management.project.dto.CreateProjectRequest;
import com.example.incident_management.project.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.example.incident_management.project.dto.ApiResponse;
import com.example.incident_management.project.dto.ProjectResponse;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ApiResponse<ProjectResponse>> createProject(@Valid @RequestBody CreateProjectRequest request) {
        ProjectResponse project = projectService.createProject(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<ProjectResponse>builder()
                        .success(true)
                        .message("Project berhasil dibuat!")
                        .data(project)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProjectResponse>>> getAllProjects() {
        List<ProjectResponse> projects = projectService.getAllProjects();

        return ResponseEntity.ok(
                ApiResponse.<List<ProjectResponse>>builder()
                        .success(true)
                        .message("Daftar project berhasil diambil!")
                        .data(projects)
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProjectResponse>> getProjectById(@PathVariable UUID id) {
        ProjectResponse project = projectService.getProjectById(id);

        return ResponseEntity.ok(
                ApiResponse.<ProjectResponse>builder()
                        .success(true)
                        .message("Project berhasil diambil!")
                        .data(project)
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProjectResponse>> updateProject(@PathVariable UUID id, @Valid @RequestBody CreateProjectRequest request) {
        ProjectResponse project = projectService.updateProject(id, request);

        return ResponseEntity.ok(
                ApiResponse.<ProjectResponse>builder()
                        .success(true)
                        .message("Project berhasil diperbarui!")
                        .data(project)
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProject(@PathVariable UUID id) {
        projectService.deleteProject(id);

        return ResponseEntity.ok(
                ApiResponse.<Void>builder()
                        .success(true)
                        .message("Project berhasil dihapus!")
                        .build()
        );
    }
}
