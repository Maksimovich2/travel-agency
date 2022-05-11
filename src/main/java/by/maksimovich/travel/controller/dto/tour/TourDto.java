package by.maksimovich.travel.controller.dto.tour;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 17:10
 */
@Data
public class TourDto {
    private Long id;
    private LocalDateTime arrivalDate;
    private LocalDateTime departureDate;
    private int countTransfers;
    private String notes;
    private String tourOperatorEmail;
    private BigDecimal price;
    private Long hotelId;
}
