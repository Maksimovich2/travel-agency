package by.maksimovich.travel.controller.convertor;

import by.maksimovich.travel.controller.dto.room.RoomDto;
import by.maksimovich.travel.controller.dto.room.RoomDtoSaveRequest;
import by.maksimovich.travel.entity.Room;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 18:19
 */
@Component
public class RoomConvertor {
    private final ModelMapper modelMapper;

    public RoomConvertor() {
        this.modelMapper = new ModelMapper();
    }

    public Room convertToEntity(RoomDto roomDto){
        return modelMapper.map(roomDto, Room.class);
    }

    public RoomDto convertToDto (Room room){
        return modelMapper.map(room, RoomDto.class);
    }

    public Room convertToEntity(RoomDtoSaveRequest roomDtoSaveRequest){
        return modelMapper.map(roomDtoSaveRequest, Room.class);
    }
}
