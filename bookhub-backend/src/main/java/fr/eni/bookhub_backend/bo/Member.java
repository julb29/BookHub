package fr.eni.bookhub_backend.bo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMember;

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

    public Member(String email, String password, String name, String firstname, String role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.firstname = firstname;
        this.role = role;
    }
}
