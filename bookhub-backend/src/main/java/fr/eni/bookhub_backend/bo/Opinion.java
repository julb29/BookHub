package fr.eni.bookhub_backend.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOpinion;

    @Column(nullable = false)
    private Float score;

    @Column(length = 1000, nullable = true)
    private String comment;

}
