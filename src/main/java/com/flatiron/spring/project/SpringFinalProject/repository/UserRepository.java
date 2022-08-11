package com.flatiron.spring.project.SpringFinalProject.repository;

import com.flatiron.spring.project.SpringFinalProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
