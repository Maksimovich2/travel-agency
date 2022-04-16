package by.maksimovich.travel.repository;

import by.maksimovich.travel.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 11:50
 */
public interface TourRepository extends JpaRepository<Tour, Long> {
}
