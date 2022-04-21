package by.maksimovich.travel.controller;

import by.maksimovich.travel.controller.convertor.TourConvertor;
import by.maksimovich.travel.controller.dto.tour.TourDto;
import by.maksimovich.travel.controller.dto.tour.TourDtoSaveRequest;
import by.maksimovich.travel.entity.Tour;
import by.maksimovich.travel.service.TourService;
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
@RequestMapping("/tour")
public class TourController {
    private final TourService tourService;
    private final TourConvertor tourConvertor;

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody TourDtoSaveRequest tourDtoSaveRequest) {
        tourService.save(tourConvertor.convertToEntity(tourDtoSaveRequest));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TourDto> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(tourConvertor
                .convertToDto(tourService.findById(id)));
    }

    @GetMapping("/tours")
    public String findAll(Model model) {
        List<Tour> tours = tourService.findAll();
        model.addAttribute("tours", tours);
        return "/tour";
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
        tourService.delete(id);
        return ResponseEntity.ok().build();
    }
}
