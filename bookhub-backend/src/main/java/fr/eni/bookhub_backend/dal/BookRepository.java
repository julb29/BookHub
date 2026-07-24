package fr.eni.bookhub_backend.dal;

import fr.eni.bookhub_backend.bo.Book;
import fr.eni.bookhub_backend.bo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Integer> {

    // Requête param avec JPQL
    List<Book> findAllByCategory_IdCategory(int idCategory);
    List<Book> findAllByAuthor_IdAuthor(int idAuthor);


}
