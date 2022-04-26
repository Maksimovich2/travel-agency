package by.maksimovich.travel.controller;

import by.maksimovich.travel.controller.convertor.HotelConvertor;
import by.maksimovich.travel.entity.Hotel;
import by.maksimovich.travel.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 16:53
 */
@Controller
@Slf4j
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;
    private final HotelConvertor convertor;

    @Value("${msg.title}")
    private String title;
//
//    @GetMapping(value = {"/", "/index"})
//    public String index(Model model) {
//        model.addAttribute("title", title);
//        return "/index";
//    }

    @PostMapping("/hotels/save")
    public String saveHotelView(@ModelAttribute("hotel") Hotel hotel) {
        hotelService.save(hotel);
        return "redirect:/hotels";
    }
    @GetMapping("/hotels/save")
    public String save(Model model) {
        Hotel hotel = new Hotel();
        model.addAttribute("hotel", hotel);
        model.addAttribute("isUpdate", false);
        return "/save-hotel";
    }

    @GetMapping("/hotels")
    public String findAll(Model model) {
        List<Hotel> hotels = hotelService.findAll();
        model.addAttribute("hotels", hotels);
        return "/hotels";
    }

    @GetMapping(value = {"/hotels/delete/{id}"})
    public String delete(@PathVariable Long id) {
            hotelService.delete(id);
            return "redirect:/hotels";
    }

    @PostMapping("/hotels/update/{id}")
    public String createUser(@ModelAttribute("hotel") Hotel hotel,
                             @PathVariable("id") Long id) {
        hotel.setId(id);
        hotelService.update(hotel);
        return "redirect:/hotels";
    }

    @GetMapping("/hotels/update/{id}")
    public String update(Model model, @PathVariable("id") Long id) {
        Hotel hotel = hotelService.findById(id);
        model.addAttribute("hotel", hotel);
        model.addAttribute("isUpdate", true);
        return "/update-hotel";
    }
}
