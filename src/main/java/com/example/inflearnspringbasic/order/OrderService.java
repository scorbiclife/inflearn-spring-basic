package com.example.inflearnspringbasic.order;

import com.example.inflearnspringbasic.order.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}