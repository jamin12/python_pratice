package hello.servlet.web.springmvc.v3;

import hello.servlet.basic.response.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberFormControllerV3 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @PostMapping("/save")
    public String save(@RequestParam("username") String userName, @RequestParam("age") int age, Model model) {
        Member member = new Member(userName, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }

    @GetMapping
    public String list(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members";
    }

    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";
    }
}
