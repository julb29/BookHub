package fr.eni.bookhub_backend.security;

import fr.eni.bookhub_backend.bo.Member;
import fr.eni.bookhub_backend.dal.MemberRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BookhubUserDetailsService implements UserDetailsService {

    private MemberRepository memberRepository;

    public BookhubUserDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email);
        if(member == null) {
            throw new UsernameNotFoundException(email);
        }

        UserBuilder userBuilder = User.builder();
        userBuilder.username(email).password(member.getPassword());
        userBuilder.roles(member.getRole());

        return userBuilder.build();

    }

}
