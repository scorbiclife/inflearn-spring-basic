package com.example.inflearnspringbasic.order;

import com.example.inflearnspringbasic.discount.DiscountStrategy;

public class Order {
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;

    public Order(Long memberId, String itemName, int itemPrice, DiscountStrategy discountStrategy) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice =
                Math.min(
                        itemPrice,
                        discountStrategy.apply(itemPrice));
    }

    public int calculatePrice() {
        return this.itemPrice - this.discountPrice;
    }
}