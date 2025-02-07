package com.example.inflearnspringbasic.discount;

import com.example.inflearnspringbasic.member.Grade;
import com.example.inflearnspringbasic.member.Member;

public class PercentageDiscountPolicy implements DiscountPolicy {
    private final int percentage;

    public PercentageDiscountPolicy(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public DiscountStrategy getDiscountStrategy(Member member) {
        return switch (member.getGrade()) {
            case BASIC -> (price) -> 0;
            case VIP -> (price) -> price * percentage / 100;
        };
    }
}
