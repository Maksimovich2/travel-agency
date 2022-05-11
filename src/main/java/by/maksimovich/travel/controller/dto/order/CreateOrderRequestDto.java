package by.maksimovich.travel.controller.dto.order;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Maksim Maksimovich
 * @created 02/05/2022 - 20:55
 */
@Data
public class CreateOrderRequestDto {
    private Long id;
    private LocalDateTime orderTime;
    private BigDecimal totalPrice;
    private String hotelName;
    private String location;
    private BigDecimal pricePerDay;
    private int countTransfers;
    private LocalDateTime arrivalDate;
    private LocalDateTime departureDate;
    private String clientLastName;
    private String clientFirstName;
}
