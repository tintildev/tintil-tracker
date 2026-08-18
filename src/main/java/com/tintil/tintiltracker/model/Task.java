package com.tintil.tintiltracker.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * 
 * Task Verwaltet die Aufgaben, mit den Eigenschaften @parm id, title, starteDate, dueDate
 * 
 * @author tintil
 * @version 1.0
 */

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    private LocalDate startDate;
    private LocalDate dueDate;

    // @Enumerated(EnumType.STRING) speichert "TODO", "IN_PROGRESS" etc. als Text in der DB,
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus status;

    @ManyToOne //Many tasks to one project
    @JoinColumn(name= "project_id", nullable = false)
    private Project project;

    //constructor for JPA/Hibernate
    public Task(){

    }

    //
    public Task(String title, String description, LocalDate startDate, LocalDate dueDate, Project project){
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.status = status;
        this.project = project;
    }

    // --- Getters und Setters
    //TODO: Getters and Setters erstellen

}

