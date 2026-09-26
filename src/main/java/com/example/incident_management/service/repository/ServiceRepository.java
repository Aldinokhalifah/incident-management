package com.example.incident_management.service.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.incident_management.service.model.Service;

public interface ServiceRepository extends JpaRepository<Service, UUID> {
    
}
