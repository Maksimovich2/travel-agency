package by.maksimovich.travel.controller.dto.hotel;

import lombok.Data;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 17:39
 */
@Data
public class HotelDtoSaveRequest {
    private String name;
    private String location;
    private int countStars;
}
