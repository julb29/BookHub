package fr.eni.bookhub_backend.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBook;

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

    @Column(nullable = true)
    private float scoreAvg;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_author")
    private Author author;


    public Book(String isbn, String title, String description, String cover, int availability) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.cover = cover;
        this.availability = availability;
    }
}
