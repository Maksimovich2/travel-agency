package by.maksimovich.travel.entity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Maksim Maksimovich
 * @created 15/04/2022 - 22:43
 */
@Entity
@Table(name = "tours")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @Column(name = "count_transfers")
    private int countTransfers;

    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Hotel hotel;
}
