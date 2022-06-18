package minsu.minsuspring.service;

import minsu.minsuspring.domain.Member;
import minsu.minsuspring.repository.MemberRepository;
import minsu.minsuspring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class Memberservice {

    private final MemberRepository memberRepository;

    public Memberservice(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    
    public  Long join(Member member){
        //중복회원 방지
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
