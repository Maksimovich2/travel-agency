package by.maksimovich.travel.controller.dto.room;

import by.maksimovich.travel.entity.Hotel;
import by.maksimovich.travel.entity.Status;
import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 17:10
 */
@Data
public class RoomDto {
    private Long id;
    private int capacity;
    private int number;

    @ColumnTransformer(read = "UPPER(operation_type)", write = "LOWER(?)")
    @Enumerated(EnumType.STRING)
    private Status status;

    private BigDecimal price;
    private Hotel hotel;
}
