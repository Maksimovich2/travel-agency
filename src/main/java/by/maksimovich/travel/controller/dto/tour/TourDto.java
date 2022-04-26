package by.maksimovich.travel.controller.dto.tour;

import by.maksimovich.travel.entity.Hotel;
import lombok.Data;

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
    private Long hotelId;
}
