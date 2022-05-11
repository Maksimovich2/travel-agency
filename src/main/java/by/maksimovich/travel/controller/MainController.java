package by.maksimovich.travel.controller;

import by.maksimovich.travel.controller.convertor.TourConvertor;
import by.maksimovich.travel.controller.dto.tour.TourDtoResponse;
import by.maksimovich.travel.entity.Tour;
import by.maksimovich.travel.service.TourService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
@Validated
@RequiredArgsConstructor
@RequestMapping
public class MainController {

    private final TourService tourService;
    private final TourConvertor tourConvertor;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping
    public String findAll(Model model, HttpServletRequest request) {
        List<Tour> tours = tourService.findAll();
        List<TourDtoResponse> tourDtoResponses = tours
                .stream()
                .map(tourConvertor::convertToDtoResponse)
                .collect(Collectors.toList());
        model.addAttribute("tours", tourDtoResponses);
        model.addAttribute("isAdmin", request.isUserInRole("ROLE_ADMIN"));
        return "/tour";
    }
}
