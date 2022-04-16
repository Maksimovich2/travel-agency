package by.maksimovich.travel.service;

import by.maksimovich.travel.entity.Hotel;
import by.maksimovich.travel.entity.Tour;

import java.util.List;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 11:55
 */
public interface TourService {
    void save(Tour tour);

    Tour findById(Long id);

    List<Tour> findAll();

    void update(Long id, Tour tour);

    void delete(Long id);
}
