package by.maksimovich.travel.service.impl;

import by.maksimovich.travel.entity.Hotel;
import by.maksimovich.travel.exception.NoDataFoundException;
import by.maksimovich.travel.repository.HotelRepository;
import by.maksimovich.travel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 11:58
 */
@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    @Override
    @Transactional
    public void save(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    @Transactional(readOnly = true)
    public Hotel findById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new NoDataFoundException("hotel not found by id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    @Transactional
    public Hotel update(Hotel hotel) {
        if (hotel.getId() == null) {
            hotel = hotelRepository.save(hotel);
            return hotel;
        } else {
            Optional<Hotel> user = hotelRepository.findById(hotel.getId());
            if (user.isPresent()) {
                Hotel newEntity = user.get();
                newEntity.setName(hotel.getName());
                newEntity.setLocation(hotel.getLocation());
                newEntity.setCountStars(hotel.getCountStars());
                newEntity = hotelRepository.save(newEntity);
                return newEntity;
            } else {
                hotel = hotelRepository.save(hotel);
                return hotel;
            }
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        hotelRepository.deleteById(id);
    }
}
