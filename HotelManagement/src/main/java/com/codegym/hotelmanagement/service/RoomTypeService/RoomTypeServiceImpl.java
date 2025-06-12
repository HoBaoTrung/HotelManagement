package com.codegym.hotelmanagement.service.RoomTypeService;

import com.codegym.hotelmanagement.model.Booking;
import com.codegym.hotelmanagement.model.Room;
import com.codegym.hotelmanagement.model.RoomType;
import com.codegym.hotelmanagement.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Override
    public List<RoomType> getAllRoomTypes() {
        return (List)roomTypeRepository.findAll();
    }

    @Override
    public List<RoomType> findAvailableRooms(Map<String, String> params) {
        LocalDate checkInDate = LocalDate.parse(params.get("checkInDate"));
        LocalDate checkOutDate = LocalDate.parse(params.get("checkOutDate"));
        int adults = Integer.parseInt(params.getOrDefault("adults", "1"));
        int childMid = Integer.parseInt(params.getOrDefault("childMid", "0"));
        int childSmall = Integer.parseInt(params.getOrDefault("childSmall", "0"));
        int totalGuests = adults + childMid + childSmall;

        return roomTypeRepository.findAvailableRooms(checkInDate, checkOutDate, totalGuests,
                Room.RoomStatus.Available,
                Arrays.asList(Booking.BookingStatus.Booked, Booking.BookingStatus.CheckedIn));

    }
}
