package by.maksimovich.travel.entity;

import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;

/**
 * @author Maksim Maksimovich
 * @created 15/04/2022 - 22:43
 */
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private int age;

    @Column(name = "sex")
    @ColumnTransformer(read = "UPPER(operation_type)", write = "LOWER(?)")
    @Enumerated(EnumType.STRING)
    private Sex sex;
}
