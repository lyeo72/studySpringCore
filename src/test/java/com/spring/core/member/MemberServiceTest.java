package com.spring.core.member;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();
    //DIP와 OCP를 잘 지키고 있는가?

    @Test
    void join() {
        //given
        Member member = new Member(1L, "유여진",Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(member.getId());
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
