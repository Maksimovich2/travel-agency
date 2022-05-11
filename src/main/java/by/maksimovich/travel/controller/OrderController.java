package by.maksimovich.travel.controller;

import by.maksimovich.travel.controller.convertor.ClientConvertor;
import by.maksimovich.travel.controller.convertor.OrderConvertor;
import by.maksimovich.travel.controller.dto.client.ClientDtoSaveRequest;
import by.maksimovich.travel.controller.dto.order.CreateOrderRequestDto;
import by.maksimovich.travel.controller.dto.order.OrderDto;
import by.maksimovich.travel.entity.Order;
import by.maksimovich.travel.entity.Tour;
import by.maksimovich.travel.service.ClientService;
import by.maksimovich.travel.service.OrderService;
import by.maksimovich.travel.service.TourService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 16:53
 */
@Controller
@Slf4j
@Validated
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final ClientService clientService;
    private final OrderConvertor orderConvertor;
    private final ClientConvertor clientConvertor;
    private final TourService tourService;

    @Secured("ROLE_ADMIN")
    @PostMapping("/save")
    public String save(CreateOrderRequestDto orderRequestDto) {
        orderService.save(orderConvertor
                .convertToEntity(orderRequestDto));
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(orderConvertor
                .convertToDto(orderService.findById(id)));
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/orders")
    public String findAll(Model model, HttpServletRequest request) {
        List<Order> orders = orderService.findAll();
        List<CreateOrderRequestDto> orderResponse = orders
                .stream()
                .map(orderConvertor::convertToDtoResponse)
                .collect(Collectors.toList());
        model.addAttribute("orders", orderResponse);
        model.addAttribute("isAdmin", request.isUserInRole("ROLE_ADMIN"));
        return "/order";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(value = {"/orders/delete/{id}"})
    public String delete(@PathVariable Long id,
                         Model model, HttpServletRequest request) {
        orderService.delete(id);
        model.addAttribute("isAdmin", request.isUserInRole("ROLE_ADMIN"));
        return "redirect:/order/orders";
    }

    @PostMapping("/make-order/{tourId}")
    public String makeOrder(@PathVariable(name = "tourId") String tourId,
                            @ModelAttribute ClientDtoSaveRequest clientDto) {
        orderService.makeOrder(Long.valueOf(tourId), clientConvertor.convertToEntity(clientDto));
        return "redirect:/order/orders";
    }

    @GetMapping("/make-order/{tourId}")
    public String makeOrderView(Model model,
                                @PathVariable Long tourId) {
        Tour tour = tourService.findById(tourId);
        ClientDtoSaveRequest clientDto = new ClientDtoSaveRequest();
         model.addAttribute("tour", tour);
        model.addAttribute("client", clientDto);
        return "/make-order";
    }
}
