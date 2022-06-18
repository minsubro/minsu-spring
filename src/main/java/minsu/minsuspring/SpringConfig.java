package minsu.minsuspring;

import minsu.minsuspring.repository.MemberRepository;
import minsu.minsuspring.repository.MemoryMemberRepository;
import minsu.minsuspring.service.Memberservice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public Memberservice memberservice(){
        return new Memberservice(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
