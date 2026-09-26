package com.example.incident_management.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.incident_management.project.dto.CreateProjectRequest;
import com.example.incident_management.project.service.ProjectService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    
}
