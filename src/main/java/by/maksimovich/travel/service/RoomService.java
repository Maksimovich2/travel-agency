package by.maksimovich.travel.service;

import by.maksimovich.travel.entity.Hotel;
import by.maksimovich.travel.entity.Room;

import java.util.List;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 11:54
 */
public interface RoomService {
    void save(Room room);

    Room findById(Long id);

    List<Room> findAll();

    void update(Long id, Room room);

    void delete(Long id);
}
