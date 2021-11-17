package hello.login.web;

import hello.login.web.member.Member;
import hello.login.web.member.MemberRepository;
import hello.login.web.session.SessionManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberRepository memberRepository;
    private final SessionManager sessionManager;

//    @GetMapping("/")
    public String home() {
        return "home";
    }

//    @GetMapping("/")
    public String loggedInHome(@CookieValue(name = "memberId", required = false) Long memberId, Model model) {
        if (Objects.isNull(memberId)) {
            return "home";
        }

        Member member = memberRepository.findById(memberId);
        if (Objects.isNull(member)) {
            return "home";
        }

        model.addAttribute("member", member);
        return "loginHome";
    }

//    @GetMapping("/")
    public String loggedInHomeV2(final HttpServletRequest request, final Model model) {
        // 세션 관리자에 저장된 회원 정보 조회
        Member member = (Member) sessionManager.getSession(request);

        if (Objects.isNull(member)) {
            return "home";
        }

        model.addAttribute("member", member);
        return "loginHome";
    }

//    @GetMapping("/")
    public String loggedInHomeV3(final HttpServletRequest request, final Model model) {
        HttpSession session = request.getSession(false);
        if (Objects.isNull(session)) {
            return "home";
        }

        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        if (Objects.isNull(member)) {
            return "home";
        }

        model.addAttribute("member", member);
        return "loginHome";
    }

    @GetMapping("/")
    public String loggedInHomeV3Spring(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member member, final Model model) {1
        if (Objects.isNull(member)) {
            return "home";
        }

        model.addAttribute("member", member);
        return "loginHome";
    }
}