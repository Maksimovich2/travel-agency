package by.maksimovich.travel.repository;

import by.maksimovich.travel.entity.Room;
import by.maksimovich.travel.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 11:50
 */
public interface TourRepository extends JpaRepository<Tour, Long> {
    @Modifying
    @Query("update Tour tour set tour = :tour where tour.id = :id")
    void update(@Param("id") Long id, @Param("tour") Tour tour);
}
