package by.maksimovich.travel.controller.dto.client;

import by.maksimovich.travel.entity.Sex;
import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 17:10
 */
@Data
public class ClientDto {
    private Long id;
    private String lastName;
    private String firstName;
    private String email;
    private int age;

    @ColumnTransformer(read = "UPPER(operation_type)", write = "LOWER(?)")
    @Enumerated(EnumType.STRING)
    private Sex sex;
}
