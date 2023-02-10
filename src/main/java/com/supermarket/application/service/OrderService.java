package com.supermarket.application.service;

import com.supermarket.application.models.Order;
import com.supermarket.application.ripository.OrderRepository;
import com.supermarket.application.ripository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    public List<Order> listAllOrder() {
        return orderRepository.findAll();
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public Order getOrder(Integer id) {
        return orderRepository.findById(id).get();
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}
