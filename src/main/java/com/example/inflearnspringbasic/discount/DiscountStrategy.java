package com.example.inflearnspringbasic.discount;

@FunctionalInterface
public interface DiscountStrategy {
    int apply(int price);
}
