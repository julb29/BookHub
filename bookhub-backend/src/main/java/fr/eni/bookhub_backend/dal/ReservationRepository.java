package fr.eni.bookhub_backend.dal;

import fr.eni.bookhub_backend.bo.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
