package com.example.inflearnspringbasic.discount;

import com.example.inflearnspringbasic.member.Member;

public class FixedPriceDiscountPolicy implements DiscountPolicy {
    private final int discountPrice;

    public FixedPriceDiscountPolicy(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public DiscountStrategy getDiscountStrategy(Member member) {
        return switch (member.getGrade()) {
            case BASIC -> (price) -> 0;
            case VIP -> (price) -> discountPrice;
        };
    }
}
