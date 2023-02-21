package com.spring.core.member;


import com.spring.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

//    MemberService memberService = new MemberServiceImpl();
    //DIP와 OCP를 잘 지키고 있는가?

    AppConfig appConfig = new AppConfig();

    @Test
    void join() {
        //given
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "유여진",Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(member.getId());
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
