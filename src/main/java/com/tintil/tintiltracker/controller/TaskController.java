package com.tintil.tintiltracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tintil.tintiltracker.model.Task;
import com.tintil.tintiltracker.service.TaskService;

/**
 * REST controller for managing tasks.
 * Provides HTTP endpoints for CRUD operations on tasks.
 * 
 */

@RestController 
@RequestMapping("/api")
public class TaskController {

    private final TaskService taskService;

    // Constructor Injection for TaskService
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Todo: create, finde, update, delete methods for tasks

    /**
     * POST /api/projects/{projectId}/tasks
     * Creates a new task assigned to a specific project.
     */
    @PostMapping("projects/{projectId}/tasks")
    public ResponseEntity<Task> createTask(@PathVariable Long projectId, @RequestBody Task task) {
        Task createdTask = taskService.createTask(projectId, task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }


}
