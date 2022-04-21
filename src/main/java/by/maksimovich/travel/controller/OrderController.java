package by.maksimovich.travel.controller;

import by.maksimovich.travel.controller.convertor.OrderConvertor;
import by.maksimovich.travel.controller.dto.order.OrderDto;
import by.maksimovich.travel.controller.dto.order.OrderDtoSaveRequest;
import by.maksimovich.travel.entity.Order;
import by.maksimovich.travel.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private final OrderConvertor convertor;

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody OrderDtoSaveRequest orderDtoSaveRequest) {
        orderService.save(convertor
                .convertToEntity(orderDtoSaveRequest));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(convertor
                .convertToDto(orderService.findById(id)));
    }

    @GetMapping("/orders")
    public String findAll(Model model) {
        List<Order> orders = orderService.findAll();
        model.addAttribute("orders", orders);
        return "/order";
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        orderService.delete(id);
        return ResponseEntity.ok().build();
    }
}
