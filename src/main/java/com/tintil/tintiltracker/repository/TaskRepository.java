package com.tintil.tintiltracker.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tintil.tintiltracker.model.Task;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository interface for Task entity.
 * Extends JpaRepository to provide CRUD operations and additional query methods.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    /**
     * Findet alle Tasks, die zu einer bestimmten Projekt-ID gehören.
     * Spring Data JPA generiert die SQL-Abfrage ("SELECT * FROM task WHERE project_id = ?")
     * automatisch aus dem Methodennamen!
     */
    List<Task> findByProjectId(Long projectId);
}
