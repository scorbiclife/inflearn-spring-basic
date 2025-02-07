package com.example.inflearnspringbasic.order;

import com.example.inflearnspringbasic.discount.FixedPriceDiscountPolicy;
import com.example.inflearnspringbasic.discount.PercentageDiscountPolicy;
import com.example.inflearnspringbasic.member.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OrderServiceImplTest {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberService memberService = new MemberService(memberRepository);
    private final OrderService orderServiceWithFixed1000Discount = new OrderServiceImpl(
            memberRepository,
            new FixedPriceDiscountPolicy(1000));
    private final OrderService orderServiceWith10PercentDiscount = new OrderServiceImpl(
            memberRepository,
            new PercentageDiscountPolicy(10));

    @Test
    void createOrderBasicMemberNoDiscount() {
        var member = new Member(null, "Foo", Grade.BASIC);
        var memberId = memberService.join(member);
        var order = orderServiceWith10PercentDiscount.createOrder(memberId, "Item A", 10000);
        var price = order.calculatePrice();
        assertThat(price).isEqualTo(10000);
    }

    @Test
    void createOrderVipMemberYesDiscount() {
        var member = new Member(null, "Foo", Grade.BASIC);
        var memberId = memberService.join(member);
        var order = orderServiceWith10PercentDiscount.createOrder(memberId, "Item A", 10000);
        var price = order.calculatePrice();
        assertThat(price).isEqualTo(9000);
    }

    @Test
    void createOrderWhenDiscountPriceGreaterThanOrderPrice() {
        var member = new Member(null, "Foo", Grade.BASIC);
        var memberId = memberService.join(member);
        var order = orderServiceWithFixed1000Discount.createOrder(memberId, "Item A", 100);
        var price = order.calculatePrice();
        assertThat(price).isEqualTo(0);
    }
}