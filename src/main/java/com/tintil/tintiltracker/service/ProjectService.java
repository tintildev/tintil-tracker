package com.tintil.tintiltracker.service;

import com.tintil.tintiltracker.model.Project;
import com.tintil.tintiltracker.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service-Klasse für die Geschäftslogik der Projektverwaltung.
 * Verwaltet Datenbankoperationen über das {@link ProjectRepository}.
 */
@Service
public class ProjectService {
    
    private final ProjectRepository projectRepository;

    /**
     * Konstruktor für Dependency Injection.
     *
     * @param projectRepository Das Repository für den Datenbankzugriff auf Projekte.
     */
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    /**
     * Ruft alle in der Datenbank gespeicherten Projekte ab.
     *
     * @return Eine Liste aller {@link Project}-Objekte.
     */
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    /**
     * Sucht ein Projekt anhand seiner ID.
     *
     * @param id Die ID des gesuchten Projekts.
     * @return Ein {@link Optional} mit dem Projekt, falls gefunden, sonst ein leeres Optional.
     */
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    /**
     * Speichert ein neues Projekt in der Datenbank.
     *
     * @param project Das zu speichernde {@link Project}-Objekt.
     * @return Das gespeicherte Projekt inklusive generierter ID.
     */
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    /**
     * Aktualisiert ein bestehendes Projekt mit neuen Daten.
     *
     * @param id            Die ID des zu aktualisierenden Projekts.
     * @param updateProject Das Objekt mit den neuen Projektdaten.
     * @return Ein {@link Optional} mit dem aktualisierten Projekt, oder ein leeres Optional, falls das Projekt nicht existiert.
     */
    public Optional<Project> updateProject(Long id, Project updateProject) {
        return projectRepository.findById(id).map(existingProject -> {
            existingProject.setTitle(updateProject.getTitle());
            existingProject.setDescription(updateProject.getDescription());
            existingProject.setCategory(updateProject.getCategory());
            return projectRepository.save(existingProject);
        });
    }
}

