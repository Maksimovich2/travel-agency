package by.maksimovich.travel.controller.dto.hotel;

import lombok.Data;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 17:09
 */
@Data
public class HotelDto {
    private Long id;
    private String name;
    private String location;
    private int countStars;
}
