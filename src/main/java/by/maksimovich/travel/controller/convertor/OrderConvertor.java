package by.maksimovich.travel.controller.convertor;

import by.maksimovich.travel.controller.dto.order.CreateOrderRequestDto;
import by.maksimovich.travel.controller.dto.order.OrderDto;
import by.maksimovich.travel.controller.dto.order.OrderDtoSaveRequest;
import by.maksimovich.travel.entity.Client;
import by.maksimovich.travel.entity.Hotel;
import by.maksimovich.travel.entity.Order;
import by.maksimovich.travel.entity.Tour;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 18:19
 */
@Component
public class OrderConvertor {
    private final ModelMapper modelMapper;

    public OrderConvertor() {
        modelMapper = new ModelMapper();
        modelMapper.typeMap(Order.class, CreateOrderRequestDto.class)
                .setPostConverter(convertToDtoResponse());
        modelMapper.typeMap(CreateOrderRequestDto.class, Order.class)
                .setPostConverter(orderDtoMakeRequestPC());
    }

    private Converter<CreateOrderRequestDto, Order> orderDtoMakeRequestPC() {
        return mappingContext -> {
            CreateOrderRequestDto source = mappingContext.getSource();
            Order destination = mappingContext.getDestination();
            Client client = new Client();
            client.setId(source.getId());
            client.setLastName(source.getClientLastName());
            client.setFirstName(source.getClientFirstName());
            destination.setClient(client);
            Tour tour = new Tour();
            tour.setPrice(source.getPricePerDay());
            Hotel hotel = new Hotel();
            hotel.setName(source.getHotelName());
            hotel.setLocation(source.getLocation());
            tour.setHotel(hotel);
            tour.setCountTransfers(source.getCountTransfers());
            tour.setDepartureDate(source.getDepartureDate());
            tour.setArrivalDate(source.getArrivalDate());
            destination.setTour(tour);
            destination.setOrderTime(LocalDateTime.now());
            destination.setId(source.getId());
            return destination;
        };
    }

    private Converter<Order, CreateOrderRequestDto> convertToDtoResponse() {
        return mappingContext -> {
            CreateOrderRequestDto destination = mappingContext.getDestination();
            Order source = mappingContext.getSource();
            destination.setDepartureDate(source.getTour().getDepartureDate());
            destination.setArrivalDate(source.getTour().getArrivalDate());
            destination.setClientFirstName(source.getClient().getFirstName());
            destination.setClientLastName(source.getClient().getLastName());
            destination.setHotelName(source.getTour().getHotel().getName());
            destination.setTotalPrice(source.getTotalPrice());
            destination.setOrderTime(LocalDateTime.now());
            destination.setCountTransfers(source.getTour().getCountTransfers());
            destination.setLocation(source.getTour().getHotel().getLocation());
            destination.setPricePerDay(source.getTour().getPrice());
            return destination;
        };
    }

    public CreateOrderRequestDto convertToDtoResponse(Order order) {
        return modelMapper.map(order, CreateOrderRequestDto.class);
    }

    public Order convertToEntity(OrderDto orderDto){
        return modelMapper.map(orderDto, Order.class);
    }

    public OrderDto convertToDto (Order order){
        return modelMapper.map(order, OrderDto.class);
    }

    public Order convertToEntity(OrderDtoSaveRequest orderDtoSaveRequest){
        return modelMapper.map(orderDtoSaveRequest, Order.class);
    }

    public Order convertToEntity(CreateOrderRequestDto dto) {
        return modelMapper.map(dto, Order.class);
    }
}
