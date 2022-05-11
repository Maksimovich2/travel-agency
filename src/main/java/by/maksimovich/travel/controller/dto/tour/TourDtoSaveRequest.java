package by.maksimovich.travel.controller.dto.tour;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 18:29
 */
@Data
public class TourDtoSaveRequest {
    private String arrivalDate;
    private String departureDate;
    private int countTransfers;
    private String notes;
    private String tourOperatorEmail;
    private BigDecimal price;
    private Long hotelId;
}
