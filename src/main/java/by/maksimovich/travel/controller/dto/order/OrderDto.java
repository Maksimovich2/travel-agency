package by.maksimovich.travel.controller.dto.order;

import by.maksimovich.travel.entity.Client;
import by.maksimovich.travel.entity.Tour;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 17:10
 */
@Data
public class OrderDto {
    private Long id;
    private LocalDateTime orderTime;
    private BigDecimal totalPrice;
    private Tour tour;
    private Client client;
}
