package com.tintil.tintiltracker.controller;

import com.tintil.tintiltracker.model.TaskStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tintil.tintiltracker.model.Task;
import com.tintil.tintiltracker.service.TaskService;

import java.util.List;
import java.util.Optional;

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

    /**
     * CREATE
     * Creates a new task assigned to a specific project.
     * POST /api/projects/{projectId}/tasks
     */
    @PostMapping("projects/{projectId}/tasks")
    public ResponseEntity<Task> createTask(@PathVariable Long projectId, @RequestBody Task task) {
        Task createdTask = taskService.createTask(projectId, task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    /**
     * FIND BY PROJECT
     * GET /api/projects/{projectId}/tasks
     * Retrieves all tasks belonging to a specific project.
     */
    @GetMapping("/projects/{projectId}/tasks")
    public ResponseEntity<List<Task>> getTasksByProjectId(@PathVariable Long projectId) {
        List<Task> taskList = taskService.getTasksByProjectId(projectId);
        return ResponseEntity.status(HttpStatus.OK).body(taskList);
    }

    /**
     * FIND BY ID
     * GET /api/tasks/{id}
     * Retrieves a single task by its ID.
     */
    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        //Optional for null check
        Optional<Task> optionalTask = taskService.getTaskById(id);
        if (optionalTask.isPresent()) {
            return ResponseEntity.ok(optionalTask.get()); // 200 OK mit Task
        } else {
            return ResponseEntity.notFound().build();     // 404 Not Found ohne Body
        }
    }

    /**
     * UPDATE
     * PATCH /api/tasks/{id}/status
     * Updates only the status of an existing task.
     */
    @PatchMapping("/tasks/{id}/status")
    public ResponseEntity<Task> updateTaskStatus(@PathVariable Long id, @RequestParam TaskStatus status) {
        Optional<Task> optionalTask = taskService.getTaskById(id);
        if(optionalTask.isPresent()) {
            Task updatedTask = taskService.updateTaskStatus(id, status);
            return ResponseEntity.ok(updatedTask); // 200 OK mit Task
        } else {
            return ResponseEntity.notFound().build();     // 404 Not Found ohne Body
        }
    }


    /**
     * DELETE
     * DELETE /api/tasks/{id}
     * Deletes a task by its ID.
     */
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        Optional<Task> optionalTask = taskService.getTaskById(id);
        if(optionalTask.isPresent()) {
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build(); // 204 No Content (Successfully deleted)
        } else {
            return ResponseEntity.noContent().build();     // 404 Not Found (The task did not exist)
        }
    }




}
