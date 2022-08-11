package com.flatiron.spring.project.SpringFinalProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "User")
@javax.persistence.Table(name = "\"User\"")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @OneToMany(mappedBy = "user")
    private ReadingList readingList;
}
