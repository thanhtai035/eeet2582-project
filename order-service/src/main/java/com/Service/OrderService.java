package com.Service;

import com.Model.OrderDetail;
import com.Model.Orders;
import com.Repository.OrderDetailRepository;
import com.Repository.OrderRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public Orders saveOrder(Orders order) {
        return orderRepository.save(order);
    }

    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {return orderDetailRepository.save(orderDetail);}
}
