package by.maksimovich.travel.controller.convertor;

import by.maksimovich.travel.controller.dto.order.OrderDto;
import by.maksimovich.travel.controller.dto.order.OrderDtoSaveRequest;
import by.maksimovich.travel.entity.Hotel;
import by.maksimovich.travel.entity.Order;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 18:19
 */
@Component
public class OrderConvertor {
    private final ModelMapper modelMapper;

    public OrderConvertor() {
        this.modelMapper = new ModelMapper();
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
}
