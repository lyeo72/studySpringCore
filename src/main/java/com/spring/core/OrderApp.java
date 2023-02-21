package com.spring.core;

import com.spring.core.member.Grade;
import com.spring.core.member.Member;
import com.spring.core.member.MemberService;
import com.spring.core.member.MemberServiceImpl;
import com.spring.core.order.Order;
import com.spring.core.order.OrderService;
import com.spring.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId =1L;
        Member member = new Member(memberId, "유여진", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "shampoo", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatorPrice = " + order.calculatorPrice());

    }
}
