package com.example.incident_management.incident.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.incident_management.incident.model.Incident;

public interface IncidentRepository extends JpaRepository<Incident, UUID> {
    
}
