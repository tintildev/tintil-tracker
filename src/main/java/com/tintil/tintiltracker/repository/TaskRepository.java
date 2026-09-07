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
     * Finds all tasks that belong to a specific project ID.
     * Spring Data JPA automatically generates the SQL query (“SELECT * FROM task WHERE project_id = ?”)
     * based on the method name!
     */
    List<Task> findByProjectId(Long projectId);
}
