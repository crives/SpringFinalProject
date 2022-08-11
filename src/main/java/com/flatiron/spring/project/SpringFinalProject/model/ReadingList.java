package com.flatiron.spring.project.SpringFinalProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
@Table(name = "ReadingList")
@NoArgsConstructor
@AllArgsConstructor
public class ReadingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "reading_lists",
            joinColumns = @JoinColumn(name = "reading_list_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    // TODO double check:
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Book> books;

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }
}
