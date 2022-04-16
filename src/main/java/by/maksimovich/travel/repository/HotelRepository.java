package by.maksimovich.travel.repository;

import by.maksimovich.travel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 11:48
 */
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
