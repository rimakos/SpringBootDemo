package com.SpringDemo.springboot.Demo.service.orderItemService;

import com.SpringDemo.springboot.Demo.dao.OrderItemRepository;
import com.SpringDemo.springboot.Demo.models.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemServiceImpl(OrderItemRepository theOrderItemRepository) {
        orderItemRepository = theOrderItemRepository;
    }

    @Override
    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem findById(int theId) {
        Optional<OrderItem> result = orderItemRepository.findById(theId);

        OrderItem theOrderItem = null;

        if (result.isPresent()) {
            theOrderItem = result.get();
        }
        else {
            throw new RuntimeException("Did not find order item id - " + theId);
        }

        return theOrderItem;
    }

    @Override
    public void save(OrderItem theOrderItem) {
        orderItemRepository.save(theOrderItem);
    }

}

