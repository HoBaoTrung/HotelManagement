package com.codegym.hotelmanagement.repository;

import com.codegym.hotelmanagement.model.Booking;
import com.codegym.hotelmanagement.model.RoomType;
import com.codegym.hotelmanagement.model.Room;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {

    @Query("SELECT DISTINCT rt FROM RoomType rt " +
            "JOIN rt.rooms r " +
            "WHERE r.status = :roomStatus " +
            "AND rt.capacity >= :totalGuests " +
            "AND NOT EXISTS (" +
            "    SELECT 1 FROM BookingDetail bd " +
            "    JOIN bd.booking b " +
            "    WHERE bd.room = r " +
            "    AND b.status IN :bookingStatuses " +
            "    AND b.checkInDate < :checkOut " +
            "    AND b.checkOutDate > :checkIn" +
            ")")
    List<RoomType> findAvailableRooms(@Param("checkIn") LocalDate checkIn,
                                      @Param("checkOut") LocalDate checkOut,
                                      @Param("totalGuests") Integer totalGuests,
                                      @Param("roomStatus") Room.RoomStatus roomStatus,
                                      @Param("bookingStatuses") List<Booking.BookingStatus> bookingStatuses);


}
