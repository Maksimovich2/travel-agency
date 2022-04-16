package by.maksimovich.travel.repository;

import by.maksimovich.travel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 11:46
 */
public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByNumber(int roomNumber);
}
