package com.codegym.hotelmanagement.model;

import javax.persistence.*;
import lombok.*;
import org.hashids.Hashids;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingDetailId;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stay_type_id")
    private StayType stayType;

    @Column(name = "price")
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BookingDetailStatus status = BookingDetailStatus.Active;
    public enum BookingDetailStatus {
        Active, Inactive
    }

}