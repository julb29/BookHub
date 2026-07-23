package fr.eni.bookhub_backend.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 17, unique = true, nullable = false)
    private String isbn;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(length = 100, nullable = false)
    private String cover;

    @Column(nullable = false)
    private int availability;

    private float scoreAvg;


    public Book(String isbn, String title, String description, String cover, int availability) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.cover = cover;
        this.availability = availability;
    }
}
