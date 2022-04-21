package by.maksimovich.travel.controller;

import by.maksimovich.travel.controller.convertor.RoomConvertor;
import by.maksimovich.travel.controller.dto.room.RoomDto;
import by.maksimovich.travel.controller.dto.room.RoomDtoSaveRequest;
import by.maksimovich.travel.entity.Room;
import by.maksimovich.travel.service.RoomService;
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
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;
    private final RoomConvertor convertor;

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody RoomDtoSaveRequest roomDtoSaveRequest) {
        roomService.save(convertor.convertToEntity(roomDtoSaveRequest));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(convertor
                .convertToDto(roomService.findById(id)));
    }

    @GetMapping("/rooms")
    public String findAll(Model model) {
        List<Room> rooms = roomService.findAll();
        model.addAttribute("rooms", rooms);
        return "/room";
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
        roomService.delete(id);
        return ResponseEntity.ok().build();
    }
}
