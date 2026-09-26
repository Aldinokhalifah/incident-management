package com.example.incident_management.project.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.incident_management.project.dto.CreateProjectRequest;
import com.example.incident_management.project.dto.ProjectResponse;
import com.example.incident_management.project.model.Project;
import com.example.incident_management.project.repository.ProjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    private ProjectResponse toResponse(Project project) {
        return ProjectResponse.builder()
            .id(project.getId())
            .name(project.getName())
            .description(project.getDescription())
            .createdAt(project.getCreatedAt())
            .updatedAt(project.getUpdatedAt())
            .build();
    }

    public ProjectResponse createProject(CreateProjectRequest request) {
        LocalDateTime now = LocalDateTime.now();
        Project project = Project.builder()
            .name(request.getName())
            .description(request.getDescription())
            .createdAt(now)
            .updatedAt(now)
            .build();
        
        Project saved = projectRepository.save(project);

        return toResponse(saved);
    }
}
