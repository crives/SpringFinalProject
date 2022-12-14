package com.flatiron.spring.project.SpringFinalProject.repository;

import com.flatiron.spring.project.SpringFinalProject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByTitleIn(List<String> titles);
}
