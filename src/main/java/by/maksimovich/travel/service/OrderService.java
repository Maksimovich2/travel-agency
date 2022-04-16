package by.maksimovich.travel.service;

import by.maksimovich.travel.entity.Hotel;
import by.maksimovich.travel.entity.Order;

import java.util.List;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 11:54
 */
public interface OrderService {
    void save(Order order);

    Order findById(Long id);

    List<Order> findAll();

    void update(Long id, Order order);

    void delete(Long id);
}
