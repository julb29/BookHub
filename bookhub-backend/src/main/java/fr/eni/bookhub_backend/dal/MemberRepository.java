package fr.eni.bookhub_backend.dal;

import fr.eni.bookhub_backend.bo.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
}
