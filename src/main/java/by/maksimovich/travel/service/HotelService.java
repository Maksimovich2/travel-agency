package by.maksimovich.travel.service;

import by.maksimovich.travel.entity.Hotel;

import java.util.List;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 11:54
 */
public interface HotelService {
    void save(Hotel hotel);

    Hotel findById(Long id);

    List<Hotel> findAll();

    Hotel update(Hotel hotel);

    void delete(Long id);
}
