package by.maksimovich.travel.repository;

import by.maksimovich.travel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 11:48
 */
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Modifying
    @Query("update Hotel hotel set hotel = :hotel where hotel.id = :id")
    void update(@Param("id") Long id, @Param("hotel") Hotel hotel);
}
