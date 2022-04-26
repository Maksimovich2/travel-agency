package by.maksimovich.travel.controller.dto.tour;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Maksim Maksimovich
 * @created 23/04/2022 - 16:36
 */
@Data
public class TourDtoResponse {
    private Long id;
    private LocalDateTime arrivalDate;
    private LocalDateTime departureDate;
    private int countTransfers;
    private String hotelName;
    private String location;
    private int countStars;
}
