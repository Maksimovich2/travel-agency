package by.maksimovich.travel.entity;

import javax.persistence.*;

/**
 * @author Maksim Maksimovich
 * @created 15/04/2022 - 22:43
 */
@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "count_stars")
    private int countStars;
}
