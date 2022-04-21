package by.maksimovich.travel.controller.convertor;

import by.maksimovich.travel.controller.dto.tour.TourDto;
import by.maksimovich.travel.controller.dto.tour.TourDtoSaveRequest;
import by.maksimovich.travel.entity.Tour;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 18:19
 */
@Component
public class TourConvertor {
    private final ModelMapper modelMapper;

    public TourConvertor() {
        this.modelMapper = new ModelMapper();
    }

    public Tour convertToEntity(TourDto tourDto){
        return modelMapper.map(tourDto, Tour.class);
    }

    public TourDto convertToDto (Tour tour){
        return modelMapper.map(tour, TourDto.class);
    }

    public Tour convertToEntity(TourDtoSaveRequest tourDtoSaveRequest){
        return modelMapper.map(tourDtoSaveRequest, Tour.class);
    }
}
