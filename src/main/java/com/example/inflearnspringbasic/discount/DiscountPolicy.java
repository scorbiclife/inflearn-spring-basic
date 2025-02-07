package com.example.inflearnspringbasic.discount;

import com.example.inflearnspringbasic.member.Member;

@FunctionalInterface
public interface DiscountPolicy {
    DiscountStrategy getDiscountStrategy(Member member);
}
