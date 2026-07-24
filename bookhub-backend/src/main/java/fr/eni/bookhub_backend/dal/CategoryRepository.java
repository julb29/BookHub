package fr.eni.bookhub_backend.dal;

import fr.eni.bookhub_backend.bo.Category;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
