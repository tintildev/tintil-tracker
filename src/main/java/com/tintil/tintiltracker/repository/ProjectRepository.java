package com.tintil.tintiltracker.repository;

import com.tintil.tintiltracker.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA Repository für die {@link Project}-Entität.
 * <p>
 * Bietet automatische Datenbankoperationen (CRUD) wie
 * {@code findAll()}, {@code findById()}, {@code save()} und {@code deleteById()}.
 * </p>
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}