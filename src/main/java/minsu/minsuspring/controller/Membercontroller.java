package minsu.minsuspring.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import minsu.minsuspring.domain.Member;
import minsu.minsuspring.service.Memberservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class Membercontroller {

    private final Memberservice memberservice;

    @Autowired
    public Membercontroller(Memberservice memberservice) {
        this.memberservice = memberservice;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    
    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        //System.out.println("member = " + member.getName());

        memberservice.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberservice.findMembers();
        model.addAttribute("members", members);
        return "members/memberlist";
    }
}
