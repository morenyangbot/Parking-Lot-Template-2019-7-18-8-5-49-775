package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entity.Order;
import com.thoughtworks.parking_lot.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements BaseService<Order, String> {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteById(String s) {
        orderRepository.deleteById(s);
    }

    @Override
    public Optional<Order> findById(String s) {
        return orderRepository.findById(s);
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }
}
