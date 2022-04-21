package by.maksimovich.travel.controller.convertor;

import by.maksimovich.travel.controller.dto.hotel.HotelDto;
import by.maksimovich.travel.controller.dto.hotel.HotelDtoSaveRequest;
import by.maksimovich.travel.entity.Hotel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 17:19
 */
@Component
public class HotelConvertor {
    private final ModelMapper modelMapper;

    public HotelConvertor() {
        this.modelMapper = new ModelMapper();
    }

    public Hotel convertToEntity(HotelDto hotelDto){
        return modelMapper.map(hotelDto, Hotel.class);
    }

    public HotelDto convertToDto (Hotel hotel){
        return modelMapper.map(hotel, HotelDto.class);
    }

    public Hotel convertToEntity(HotelDtoSaveRequest hotelDtoSaveRequest){
        return modelMapper.map(hotelDtoSaveRequest, Hotel.class);
    }
}
