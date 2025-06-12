package com.codegym.hotelmanagement.controller.Booking;

import com.codegym.hotelmanagement.DTO.BookingDTO;
import com.codegym.hotelmanagement.model.RoomType;
import com.codegym.hotelmanagement.service.RoomTypeService.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RequestMapping("/booking")
@Controller
public class BookingController {

    @Autowired
    private RoomTypeService roomTypeService;


    @GetMapping
    public ModelAndView booking(@RequestParam Map<String, String> params) {
        List<RoomType> availableRoomTypes;
        if(params.isEmpty()){
            availableRoomTypes = roomTypeService.getAllRoomTypes();
        }
        else{
            availableRoomTypes = roomTypeService.findAvailableRooms(params);
        }

        ModelAndView modelAndView = new ModelAndView("booking/index");
        modelAndView.addObject("rooms", availableRoomTypes);
        return modelAndView;
    }


    @PostMapping("/submit")
    public String processBooking(@ModelAttribute BookingDTO bookingDTO, Model model) {
        // TODO: Save booking, validate logic, check room availability, etc.
        model.addAttribute("message", "Đặt phòng thành công!");
        return "booking_success";
    }

}
