package by.maksimovich.travel.service.impl;

import by.maksimovich.travel.entity.Tour;
import by.maksimovich.travel.exception.NoDataFoundException;
import by.maksimovich.travel.repository.TourRepository;
import by.maksimovich.travel.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 11:59
 */
@Service
@RequiredArgsConstructor
public class TourServiceImpl implements TourService {
    private final TourRepository tourRepository;

    @Override
    @Transactional
    public void save(Tour tour) {
        tourRepository.save(tour);
    }

    @Override
    @Transactional(readOnly = true)
    public Tour findById(Long id) {
        return tourRepository.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Tour not found by id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tour> findAll() {
        return tourRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Long id, Tour tour) {
        Tour tourToSave = tourRepository.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Tour not found by id: " + id));
        tourToSave.setArrivalDate(tour.getArrivalDate());
        tourToSave.setDepartureDate(tour.getDepartureDate());
        tourToSave.setCountTransfers(tour.getCountTransfers());
        tourToSave.setHotel(tour.getHotel());
        tourRepository.save(tourToSave);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        tourRepository.deleteById(id);
    }
}
