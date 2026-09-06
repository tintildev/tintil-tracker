package com.tintil.tintiltracker.service;

import com.tintil.tintiltracker.model.Task;
import com.tintil.tintiltracker.model.TaskStatus;
import com.tintil.tintiltracker.repository.ProjectRepository;
import com.tintil.tintiltracker.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the {@link TaskService} interface.
 * Handles business logic for managing tasks.
 */

public class TaskServiceImpl implements TaskService{

    @Override
    public Task createTask(Long projectId, Task task) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createTask'");
    }

    @Override
    public List<Task> getTasksByProjectId(Long projectId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTasksByProjectId'");
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTaskById'");
    }

    @Override
    public Task updateTaskStatus(Long taskId, TaskStatus status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTaskStatus'");
    }

    @Override
    public void deleteTask(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteTask'");
    }

}
