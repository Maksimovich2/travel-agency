package by.maksimovich.travel.service.impl;

import by.maksimovich.travel.entity.Room;
import by.maksimovich.travel.exception.NoDataFoundException;
import by.maksimovich.travel.repository.RoomRepository;
import by.maksimovich.travel.service.RoomService;
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
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    @Override
    @Transactional
    public void save(Room room) {
        roomRepository.save(room);
    }

    @Override
    @Transactional(readOnly = true)
    public Room findById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Room not found by id" + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Long id, Room room) {
        roomRepository.update(id, room);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        roomRepository.deleteById(id);
    }
}
