package com.tintil.tintiltracker.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Repräsentiert ein Projekt im Tintil Tracker System.
 * Diese Entity-Klasse wird von JPA auf die Datenbanktabelle "projects"
 * abgebildet.
 */
@Entity
@Table(name = "projects")
public class Project {

    /**
     * Eindeutige ID des Projekts (Primärschlüssel, wird automatisch von der
     * Datenbank generiert).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Der Titel des Projekts. Darf nicht null sein. */
    @Column(nullable = false)
    private String title;

    /** Eine ausführliche Beschreibung des Projekts. */
    private String description;

    /** Die Kategorie des Projekts (z. B. "Software", "Werkstatt", "Lernen"). */
    private String category;

    /** Zeitpunkt, zu dem das Projekt erstellt wurde. */
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

    /**
     * Standard-Konstruktor.
     * Wichtig für JPA/Hibernate zur Instanziierung der Entity.
     */
    public Project() {
    }

    /**
     * Erstellt ein neues Projekt mit Titel, Beschreibung und Kategorie.
     * Das Erstellungsdatum {@link #createdAt} wird automatisch gesetzt.
     *
     * @param title       Der Titel des Projekts.
     * @param description Die Beschreibung des Projekts.
     * @param category    Die Kategorie des Projekts.
     */
    public Project(String title, String description, String category) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.createdAt = LocalDateTime.now();
    }

    /**
     * JPA-Lifecycle-Hook: Wird automatisch vor dem ersten Speichern ausgeführt,
     * um {@link #createdAt} zu setzen, falls es noch nicht vorhanden ist.
     */
    @PrePersist
    protected void onCreate() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    // Helper Methode
    public void addTask(Task task) {
    tasks.add(task);
    task.setProject(this);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        task.setProject(null);
    }

    // --- Getter und Setter ---

    /**
     * Liefert die ID des Projekts zurück.
     *
     * @return Die ID des Projekts.
     */
    public Long getId() {
        return id;
    }

    /**
     * Setzt die ID des Projekts.
     *
     * @param id Die neu zuzuweisende ID.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Liefert den Titel des Projekts zurück.
     *
     * @return Der Titel des Projekts.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setzt den Titel des Projekts.
     *
     * @param title Der neue Titel.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Liefert die Beschreibung des Projekts zurück.
     *
     * @return Die Beschreibung des Projekts.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setzt die Beschreibung des Projekts.
     *
     * @param description Die neue Beschreibung.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Liefert die Kategorie des Projekts zurück.
     *
     * @return Die Kategorie des Projekts.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Setzt die Kategorie des Projekts.
     *
     * @param category Die neue Kategorie.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Liefert den Erstellungszeitpunkt des Projekts zurück.
     *
     * @return Der Zeitpunkt als {@link LocalDateTime}.
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Setzt den Erstellungszeitpunkt des Projekts.
     *
     * @param createdAt Der neue Erstellungszeitpunkt.
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Task> getTasks() {
    return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    
}