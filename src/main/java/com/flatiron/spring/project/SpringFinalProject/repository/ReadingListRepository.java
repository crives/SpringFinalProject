package com.flatiron.spring.project.SpringFinalProject.repository;

import com.flatiron.spring.project.SpringFinalProject.model.ReadingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingListRepository extends JpaRepository<ReadingList, Long> {

}
