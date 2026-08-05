package com.tintil.tintiltracker.repository;

import com.tintil.tintiltracker.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Database Access via Spring Data JPA
 */

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // JpaRepository bringt automatisch CRUD-Methoden mit:
    // findAll(), findById(), save(), deleteById(), etc.
}