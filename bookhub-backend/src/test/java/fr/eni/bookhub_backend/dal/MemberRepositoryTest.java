package fr.eni.bookhub_backend.dal;

import fr.eni.bookhub_backend.bo.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testMemberCreationPositiveCase(){
        // AAA

        // Arrange
        Member member = new Member("toto@eni.fr", "password", "Jonathan", "David", "fake_role");
        member.setPhone("0618654516");

        // Act
        Member memberBD = memberRepository.save(member);

        // Assert
        assertThat(memberBD).isNotNull();
        assertThat(memberBD.getIdMember()).isNotNull();
        assertThat(memberBD.getFirstname()).isEqualTo("David");
        assertThat(memberBD.getEmail()).isEqualTo("toto@eni.fr");
        assertThat(memberBD.getPassword()).isEqualTo("password");
        assertThat(memberBD.getPhone()).isEqualTo("0618654516");
    }

}
