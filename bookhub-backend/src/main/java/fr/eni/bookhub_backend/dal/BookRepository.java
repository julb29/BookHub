package fr.eni.bookhub_backend.dal;

import fr.eni.bookhub_backend.bo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
