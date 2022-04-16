package by.maksimovich.travel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Maksim Maksimovich
 * @created 15/04/2022 - 22:43
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_time")
    private LocalDate orderTime;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @JoinColumn(name = "toor_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Tour tour;

    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;
}
