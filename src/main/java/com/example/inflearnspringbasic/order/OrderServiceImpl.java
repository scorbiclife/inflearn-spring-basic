package com.example.inflearnspringbasic.order;

import com.example.inflearnspringbasic.discount.DiscountPolicy;
import com.example.inflearnspringbasic.discount.DiscountStrategy;
import com.example.inflearnspringbasic.member.Member;
import com.example.inflearnspringbasic.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        DiscountStrategy discountStrategy = discountPolicy.getDiscountStrategy(member);
        return new Order(memberId, itemName, itemPrice, discountStrategy);
    }
}