package com.flatiron.spring.project.SpringFinalProject.repository;

import com.flatiron.spring.project.SpringFinalProject.model.ReadingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadingListRepository extends JpaRepository<ReadingList, Long> {
    List<ReadingList> findAllByUserId(Long userId);

    List<ReadingList> findAllByIdAndUserId(Long id, Long userId);
}
