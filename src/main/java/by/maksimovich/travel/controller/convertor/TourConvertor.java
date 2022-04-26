package by.maksimovich.travel.controller.convertor;

import by.maksimovich.travel.controller.dto.tour.TourDto;
import by.maksimovich.travel.controller.dto.tour.TourDtoResponse;
import by.maksimovich.travel.controller.dto.tour.TourDtoSaveRequest;
import by.maksimovich.travel.entity.Tour;
import org.modelmapper.Converter;
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
        modelMapper = new ModelMapper();
        modelMapper.typeMap(Tour.class, TourDtoResponse.class)
                .setPostConverter(convertToDtoResponse());
    }

    private Converter<Tour, TourDtoResponse> convertToDtoResponse() {
        return mappingContext -> {
            TourDtoResponse destination = mappingContext.getDestination();
            Tour source = mappingContext.getSource();
            destination.setHotelName(source.getHotel().getName());
            destination.setCountStars(source.getHotel().getCountStars());
            destination.setLocation(source.getHotel().getLocation());
            destination.setArrivalDate(source.getArrivalDate());
            destination.setDepartureDate(source.getDepartureDate());
            destination.setCountTransfers(source.getCountTransfers());
            return destination;
        };
    }

    public TourDtoResponse convertToDtoResponse(Tour tour) {
        return modelMapper.map(tour, TourDtoResponse.class);
    }

    public Tour convertToEntity(TourDto tourDto) {
        return modelMapper.map(tourDto, Tour.class);
    }

    public TourDto convertToDto(Tour tour) {
        return modelMapper.map(tour, TourDto.class);
    }

    public Tour convertToEntity(TourDtoSaveRequest tourDtoSaveRequest) {
        return modelMapper.map(tourDtoSaveRequest, Tour.class);
    }
}
