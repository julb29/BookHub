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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_author", nullable = false)
    private Author author;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="id_category", nullable = false)
    private Category category;
}
