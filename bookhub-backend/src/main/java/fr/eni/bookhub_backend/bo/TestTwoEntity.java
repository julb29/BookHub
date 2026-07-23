package fr.eni.bookhub_backend.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class TestTwoEntity {
    @Id
    private Long id;

    private String desc;

}
