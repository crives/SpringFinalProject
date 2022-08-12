package com.flatiron.spring.project.SpringFinalProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Book")
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    // TODO Must have pages
    private int pages;

    // TODO Must be before today
    @Temporal(TemporalType.DATE)
    private Date published;

    @ManyToOne
    private Author author;

    @ManyToMany
    @JoinTable(
            name = "genres",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Genre> genres;

    public void addGenre(Genre genre) {
        genres.add(genre);
    }

    public List<Genre> getGenres() {
        return genres;
    }
}
