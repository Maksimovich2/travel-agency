package by.maksimovich.travel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Maksim Maksimovich
 * @created 15/04/2022 - 22:43
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tours")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "arrival_date")
    private LocalDateTime arrivalDate;

    @Column(name = "departure_date")
    private LocalDateTime departureDate;

    @Column(name = "count_transfers")
    private int countTransfers;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "tour_operator_email")
    private String tourOperatorEmail;

    @Column(name = "notes")
    private String notes;

    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Hotel hotel;
}
