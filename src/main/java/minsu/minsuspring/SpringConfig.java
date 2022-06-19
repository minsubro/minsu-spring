package minsu.minsuspring;

import minsu.minsuspring.repository.*;
import minsu.minsuspring.service.Memberservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public Memberservice memberservice(){
        return new Memberservice(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
//        //return new MemoryMemberRepository();
//        //return new jdbcMemberRepository(dataSource);
//        //return new JdbcTemplateMemberRepository(dataSource);
//        //return new JpaMemberRepository(em);
//    }
}
