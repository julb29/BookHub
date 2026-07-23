package fr.eni.bookhub_backend.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@RequiredArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    private Long idMember;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String firstname;

    @Column(length = 10)
    private String phone;

    @Column(nullable = false)
    private String role;

}
