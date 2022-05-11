package by.maksimovich.travel.controller;

import by.maksimovich.travel.controller.convertor.HotelConvertor;
import by.maksimovich.travel.entity.Hotel;
import by.maksimovich.travel.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @Secured("ROLE_ADMIN")
    @PostMapping("/hotels/save")
    public String saveHotelView(@ModelAttribute("hotel") Hotel hotel) {
        hotelService.save(hotel);
        return "redirect:/hotels";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/hotels/save")
    public String save(Model model) {
        Hotel hotel = new Hotel();
        model.addAttribute("hotel", hotel);
        model.addAttribute("isUpdate", false);
        return "/save-hotel";
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/hotels")
    public String findAll(Model model, HttpServletRequest request) {
        List<Hotel> hotels = hotelService.findAll();
        model.addAttribute("hotels", hotels);
        model.addAttribute("isAdmin", request.isUserInRole("ROLE_ADMIN"));
        return "/hotels";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(value = {"/hotels/delete/{id}"})
    public String delete(@PathVariable Long id) {
        hotelService.delete(id);
        return "redirect:/hotels";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/hotels/update/{id}")
    public String updateHotel(@ModelAttribute("hotel") Hotel hotel,
                              @PathVariable("id") Long id) {
        hotel.setId(id);
        hotelService.update(hotel);
        return "redirect:/hotels";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/hotels/update/{id}")
    public String update(Model model, @PathVariable("id") Long id) {
        Hotel hotel = hotelService.findById(id);
        model.addAttribute("hotel", hotel);
        model.addAttribute("isUpdate", true);
        return "/update-hotel";
    }
}
