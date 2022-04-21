package by.maksimovich.travel.repository;

import by.maksimovich.travel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 11:48
 */
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
