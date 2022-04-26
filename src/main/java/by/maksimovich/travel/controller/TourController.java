package by.maksimovich.travel.controller;

import by.maksimovich.travel.controller.convertor.TourConvertor;
import by.maksimovich.travel.controller.dto.tour.TourDto;
import by.maksimovich.travel.controller.dto.tour.TourDtoResponse;
import by.maksimovich.travel.controller.dto.tour.TourDtoSaveRequest;
import by.maksimovich.travel.entity.Tour;
import by.maksimovich.travel.service.HotelService;
import by.maksimovich.travel.service.TourService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/tours")
public class TourController {
    private final TourService tourService;
    private final HotelService hotelService;
    private final TourConvertor tourConvertor;

    @Secured("ROLE_ADMIN")
    @PostMapping
    public String save(TourDtoSaveRequest tourDtoSaveRequest) {
        tourService.save(tourConvertor.convertToEntity(tourDtoSaveRequest));
        return "redirect:/";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/save-tour-form")
    public String saveForm(Model model) {
        model.addAttribute("isUpdate", false);
        model.addAttribute("hotels", hotelService.findAll());//TODO не отдавать ентити
        return "/create-tour";
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/{id}")
    public ResponseEntity<TourDto> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(tourConvertor
                .convertToDto(tourService.findById(id)));
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/tours")
    public String findAll(Model model) {
        List<Tour> tours = tourService.findAll();
        List<TourDtoResponse> tourDtoResponses = tours
                .stream()
                .map(tourConvertor::convertToDtoResponse)
                .collect(Collectors.toList());
        model.addAttribute("tours", tourDtoResponses);
        return "/tour";
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
        tourService.delete(id);
        return ResponseEntity.ok().build();
    }
}
