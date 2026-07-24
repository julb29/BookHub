package fr.eni.bookhub_backend.dal;

import fr.eni.bookhub_backend.bo.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpinionRepository extends JpaRepository<Opinion, Integer> {
}
