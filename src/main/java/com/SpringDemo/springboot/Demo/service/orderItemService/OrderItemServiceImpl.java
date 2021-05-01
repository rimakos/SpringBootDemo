package com.SpringDemo.springboot.Demo.service.orderItemService;

import com.SpringDemo.springboot.Demo.dao.OrderItemRepository;
import com.SpringDemo.springboot.Demo.models.Order;
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
        return orderItemRepository.findById(theId).orElse(null);
    }
    @Override
    public void save(OrderItem theOrderItem) {
        orderItemRepository.save(theOrderItem);
    }




    @Override
    public String deleteById(int theId) {
        Optional<OrderItem> order = orderItemRepository.findById(theId);
        if (order.isPresent()) {
            orderItemRepository.deleteById(theId);
            return "The order item with id " + theId + " is deleted";
        } else {
            return "The id " + theId + " you enter to delete does not exist";
        }
    }
}

