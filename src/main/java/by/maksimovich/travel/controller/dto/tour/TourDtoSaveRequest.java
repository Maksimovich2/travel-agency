package by.maksimovich.travel.controller.dto.tour;

import by.maksimovich.travel.entity.Hotel;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 18:29
 */
@Data
public class TourDtoSaveRequest {
    private LocalDateTime arrivalDate;
    private LocalDateTime departureDate;
    private int countTransfers;
    private Hotel hotel;
}
