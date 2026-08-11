package com.tintil.tintiltracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.tintil.tintiltracker.model.Project;
import com.tintil.tintiltracker.repository.ProjectRepository;

/**
 * REST-Controller für die Verwaltung von Projekten über HTTP-Endpunkte.
 * Bietet Schnittstellen für CRUD-Operationen unter der Basis-URL {@code /api/projects}.
 */
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    /**
     * Erstellt einen neuen REST-Controller mit Dependency Injection des Services.
     *
     * @param projectService Der Service für den Datenzugriff auf Projekte.
     */
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * Ruft alle in der Datenbank verfügbaren Projekte ab.
     * <p>HTTP-Methode: GET /api/projects</p>
     *
     * @return Eine Liste aller {@link Project}-Objekte.
     */
    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    /**
     * Erstellt ein neues Projekt in der Datenbank.
     * <p>HTTP-Methode: POST /api/projects</p>
     *
     * @param project Das im JSON-Format im Request-Body übergebene {@link Project}.
     * @return Das erstellte Projekt mit HTTP-Status 201 (CREATED).
     */
    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project savedProject = projectService.createProject(project);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }

    /**
     * Sucht ein einzelnes Projekt anhand seiner eindeutigen ID.
     * <p>HTTP-Methode: GET /api/projects/{id}</p>
     *
     * @param id Die ID des gesuchten Projekts aus der URL.
     * @return {@link ResponseEntity} mit dem Projekt (200 OK) oder 404 NOT FOUND.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id)
                .map(project -> ResponseEntity.ok(project))
                .orElse(ResponseEntity.notFound().build());
    }
}

