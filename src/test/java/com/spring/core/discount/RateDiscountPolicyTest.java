package com.spring.core.discount;

import com.spring.core.member.Grade;
import com.spring.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    @Test
    void rateDiscountTest() {
        //given
        Member member = new Member(1L, "변지윤", Grade.VIP);

        //when
        DiscountPolicy discountPolicy = new RateDiscountPolicy();
        int discount = discountPolicy.discount(member, 10000);


        //then
        Assertions.assertThat(discount).isEqualTo(10000 / 10);

    }

}