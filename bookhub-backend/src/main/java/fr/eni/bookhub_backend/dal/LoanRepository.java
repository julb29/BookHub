package fr.eni.bookhub_backend.dal;

import fr.eni.bookhub_backend.bo.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
