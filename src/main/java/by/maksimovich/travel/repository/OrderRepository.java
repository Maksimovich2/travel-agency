package by.maksimovich.travel.repository;

import by.maksimovich.travel.entity.Hotel;
import by.maksimovich.travel.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 11:49
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Modifying
    @Query("update Order order set order = :order where order.id = :id")
    void update(@Param("id") Long id, @Param("order") Order order);
}
