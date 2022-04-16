package by.maksimovich.travel.repository;

import by.maksimovich.travel.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 11:49
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
