package by.maksimovich.travel.service.impl;

import by.maksimovich.travel.entity.Client;
import by.maksimovich.travel.entity.Order;
import by.maksimovich.travel.entity.Tour;
import by.maksimovich.travel.exception.NoDataFoundException;
import by.maksimovich.travel.repository.OrderRepository;
import by.maksimovich.travel.service.ClientService;
import by.maksimovich.travel.service.OrderService;
import by.maksimovich.travel.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.concurrent.TimeUnit.DAYS;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 11:59
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ClientService clientService;
    private final TourService tourService;

    @Override
    @Transactional
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    @Transactional(readOnly = true)
    public Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Order not found by id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Long id, Order order) {
        Order orderToUpdate = orderRepository.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Order not found by id: " + id));
        orderToUpdate.setOrderTime(order.getOrderTime());
        orderToUpdate.setTour(order.getTour());
        orderToUpdate.setTotalPrice(order.getTotalPrice());
        orderToUpdate.setClient(order.getClient());
        orderRepository.save(orderToUpdate);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void makeOrder(Long tourId, Client client) {
        Tour tour = tourService.findById(tourId);
        clientService.save(client);
        if (client != null && tour != null){
            BigDecimal totalPriceForOrder = calculateOrderPrice(
                    tour.getArrivalDate(),
                    tour.getDepartureDate(),
                    tour.getPrice());

            Order order = new Order(LocalDateTime.now(), totalPriceForOrder, tour, client);
            orderRepository.save(order);
        }
    }

    private BigDecimal calculateOrderPrice(LocalDateTime arrival, LocalDateTime departure, BigDecimal price){
        long dif = DAYS.toChronoUnit().between(departure, arrival);
        return price.multiply(BigDecimal.valueOf(dif));
    }
}
