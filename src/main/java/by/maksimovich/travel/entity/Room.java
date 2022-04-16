package by.maksimovich.travel.entity;

import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Maksim Maksimovich
 * @created 15/04/2022 - 22:44
 */

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "number")
    private int number;

    @Column(name = "status")
    @ColumnTransformer(read = "UPPER(operation_type)", write = "LOWER(?)")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "price")
    private BigDecimal price;

    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Hotel hotel;
}
