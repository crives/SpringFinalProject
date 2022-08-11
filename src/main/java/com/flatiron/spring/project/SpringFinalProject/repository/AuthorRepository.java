package com.flatiron.spring.project.SpringFinalProject.repository;

import com.flatiron.spring.project.SpringFinalProject.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
