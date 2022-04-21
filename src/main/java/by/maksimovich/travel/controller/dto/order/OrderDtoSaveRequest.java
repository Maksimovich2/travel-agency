package by.maksimovich.travel.controller.dto.order;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 18:21
 */
@Data
public class OrderDtoSaveRequest {
    private LocalDateTime orderTime;
    private BigDecimal totalPrice;
    private Long tourId;
    private Long clientId;
}
