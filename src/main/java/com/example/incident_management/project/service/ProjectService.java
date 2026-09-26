package com.example.incident_management.project.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public List<ProjectResponse> getAllProjects() {
        List<Project> projects = projectRepository.findAll();

        List<ProjectResponse> responses = projects.stream().map(this::toResponse).collect(Collectors.toList());

        return responses;
    }

    public ProjectResponse getProjectById(UUID id) {
        Project project = projectRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Project tidak ditemukan!"));

        return toResponse(project);
    }

    public ProjectResponse updateProject(UUID id, CreateProjectRequest request) {
        Project project = projectRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Project tidak ditemukan!"));

        project.setName(request.getName());
        project.setDescription(request.getDescription());
        project.setUpdatedAt(LocalDateTime.now());

        Project saved = projectRepository.save(project);

        return toResponse(saved);
    }


    public void deleteProject(UUID id) {
        Project project = projectRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Project tidak ditemukan!"));

        projectRepository.delete(project);
    }
}
