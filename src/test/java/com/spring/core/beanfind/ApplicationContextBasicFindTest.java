package com.spring.core.beanfind;

import com.spring.core.AppConfig;
import com.spring.core.member.MemberService;
import com.spring.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService = " + memberService); //이름
        System.out.println("memberService.getClass() = " + memberService.getClass()); //타입
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // memberService가 memberSeriviceInpl

    }

    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void findByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        System.out.println("memberService = " + memberService); //이름
        System.out.println("memberService.getClass() = " + memberService.getClass()); //타입
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회") //인터페이스가 아닌 구체타입으로 조회함
    void findByName2() {
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // memberService가 memberSeriviceInpl
    }

    @Test
    @DisplayName("빈이름으로 조회x") //인터페이스가 아닌 구체타입으로 조회함
    void findByName_x() {
//        MemberService zzz = ac.getBean("ZZZ", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class, () ->ac.getBean("ZZZ", MemberService.class));
    }

    //동일한 타입이 두개 이상 있을때

}
