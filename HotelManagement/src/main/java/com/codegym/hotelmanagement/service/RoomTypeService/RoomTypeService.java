package com.codegym.hotelmanagement.service.RoomTypeService;

import com.codegym.hotelmanagement.model.RoomType;

import java.util.List;
import java.util.Map;

public interface RoomTypeService {
    List<RoomType> getAllRoomTypes();
    List<RoomType> findAvailableRooms(Map<String, String> params);
}
