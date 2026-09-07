package com.tintil.tintiltracker.service;

import com.tintil.tintiltracker.model.Project;
import com.tintil.tintiltracker.model.Task;
import com.tintil.tintiltracker.model.TaskStatus;
import com.tintil.tintiltracker.repository.ProjectRepository;
import com.tintil.tintiltracker.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the {@link TaskService} interface.
 * Handles business logic for managing tasks.
 */

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    //Constructor Injection for TaskRepository and ProjectRepository
    public TaskServiceImpl(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public Task createTask(Long projectId, Task task) {
        // Retrieve the project from the database and display an error message if it is not found
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new IllegalArgumentException("Project not found with id: " + projectId));
        // Assign the project to the task and save the task
        task.setProject(project);
        // Save the task to the database and return it
        return taskRepository.save(task);
        
    }

    @Override
    public List<Task> getTasksByProjectId(Long projectId) {
        // Retrieve all tasks associated with the specified project ID
        return taskRepository.findByProjectId(projectId);
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        // Finden the task by its ID and return it as an Optional
        return taskRepository.findById(id);
    }

    @Override
    @Transactional
    public Task updateTaskStatus(Long taskId, TaskStatus status) {
        // task from the database and display an error message if it is not found
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new IllegalArgumentException("Task not found with id: " + taskId));
        // set Status of the task and save it to the database
        task.setStatus(status);
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        // delete the task by its ID from the database
        taskRepository.deleteById(id);
    }

}
