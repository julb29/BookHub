package fr.eni.bookhub_backend.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.datetime.standard.DateTimeContext;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLoan;

    @Column(nullable = false)
    private LocalDateTime dateLoan;

    @Column(nullable = true)
    private LocalDateTime dateReturn;
}
