package com.tintil.tintiltracker.service;

import java.util.List;
import java.util.Optional;

import com.tintil.tintiltracker.model.Task;
import com.tintil.tintiltracker.model.TaskStatus;

/**
 * Service interface defining business logic operations for Tasks.
 */
public interface TaskService {

    /**
     * Erstellt einen neuen Task und ordnet ihn einem bestehenden Projekt zu.
     */
    Task createTask(Long projectId, Task task);

    /**
     * Liefert alle Tasks zurück, die zu einem bestimmten Projekt gehören.
     */
    List<Task> getTasksByProjectId(Long projectId);

    /**
     * Sucht einen einzelnen Task anhand seiner ID.
     */
    Optional<Task> getTaskById(Long id);

    /**
     * Aktualisiert nur den Status eines Tasks (z. B. TODO -> IN_PROGRESS).
     */
    Task updateTaskStatus(Long taskId, TaskStatus status);

    /**
     * Löscht einen Task anhand seiner ID.
     */
    void deleteTask(Long id);
}
