package by.maksimovich.travel.controller.dto.room;

import by.maksimovich.travel.entity.Hotel;
import by.maksimovich.travel.entity.Status;
import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 18:27
 */
@Data
public class RoomDtoSaveRequest {
    private int capacity;
    private int number;

    @ColumnTransformer(read = "UPPER(status)", write = "LOWER(?)")
    @Enumerated(EnumType.STRING)
    private Status status;

    private BigDecimal price;
    private Hotel hotel;
}
