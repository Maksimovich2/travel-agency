package by.maksimovich.travel.repository;

import by.maksimovich.travel.entity.Hotel;
import by.maksimovich.travel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 11:46
 */
public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByNumber(int roomNumber);

    @Modifying
    @Query("update Room room set room = :room where room.id = :id")
    void update(@Param("id") Long id, @Param("room") Room room);
}
