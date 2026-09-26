package com.example.incident_management.project.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.incident_management.project.model.Project;

public interface ProjectRepository extends JpaRepository<Project, UUID> {
    
}
