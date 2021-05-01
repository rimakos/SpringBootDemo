package com.SpringDemo.springboot.Demo.service.orderService;

import com.SpringDemo.springboot.Demo.dao.OrderItemRepository;
import com.SpringDemo.springboot.Demo.dao.OrderRepository;
import com.SpringDemo.springboot.Demo.models.Order;
import com.SpringDemo.springboot.Demo.models.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository theOrderRepository, OrderItemRepository theOrderItemRepository) {
        orderRepository = theOrderRepository;
        orderItemRepository = theOrderItemRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAllByOrderByIdAsc();
    }

    @Override
    public List<Order> getUserOrders(int userId) {
        return orderRepository.getUserOrders(userId);
    }

    @Override
    public Order findById(int theId) {

        return orderRepository.findById(theId).orElse(null);
    }

    @Override
    public String deleteById(int theId) {
        Optional<Order> order = orderRepository.findById(theId);
        if (order.isPresent()) {
            orderRepository.deleteById(theId);
            return "The order with id " + theId + " is deleted";
        } else {
            return "The id " + theId + " you enter to delete does not exist";
        }
    }

    @Override
    public int save(Order theOrder) {
        Order newOrder = new Order();
        newOrder.setUserId(theOrder.getUser().getId());
        orderRepository.save(newOrder);

        for (OrderItem orderItem : theOrder.getOrderItems()) {
            OrderItem newOrderItem = new OrderItem();
            newOrderItem.setOrdersItemId(newOrder.getId());
            newOrderItem.setQuantity(orderItem.getQuantity());
            newOrderItem.setPrice(orderItem.getPrice());
            newOrderItem.setItems(orderItem.getItems());
            orderItemRepository.save(newOrderItem);
        }
        return newOrder.getId();
    }
}
