package by.maksimovich.travel.service.impl;

import by.maksimovich.travel.entity.Order;
import by.maksimovich.travel.exception.NoDataFoundException;
import by.maksimovich.travel.repository.OrderRepository;
import by.maksimovich.travel.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 11:59
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    @Transactional(readOnly = true)
    public Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Order not found by id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Long id, Order order) {
        Order orderToUpdate = orderRepository.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Order not found by id: " + id));
        orderToUpdate.setOrderTime(order.getOrderTime());
        orderToUpdate.setTour(order.getTour());
        orderToUpdate.setTotalPrice(order.getTotalPrice());
        orderToUpdate.setClient(order.getClient());
        orderRepository.save(orderToUpdate);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
