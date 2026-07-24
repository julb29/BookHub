package fr.eni.bookhub_backend.dal;

import fr.eni.bookhub_backend.bo.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
