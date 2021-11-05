package hello.login.domain.login;

import hello.login.web.member.Member;
import hello.login.web.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    /**
     *
     * @param loginId
     * @param password
     * @return null 로그인 실패
     */
    public Member login(final String loginId, final String password) {
        return memberRepository.findByLoginId(loginId)
                .filter(member -> member.isEqualPassword(password))
                .orElse(null);
    }
}
