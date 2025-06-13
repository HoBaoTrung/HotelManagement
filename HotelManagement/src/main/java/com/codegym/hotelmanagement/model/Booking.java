package com.codegym.hotelmanagement.model;

import javax.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private LocalDateTime bookingDate;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    public enum BookingStatus {
        Booked, CheckedIn, Cancelled, CheckedOut
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "booking_type")
    private BookingType bookingType = BookingType.Online;
    public enum BookingType {
        Online, WalkIn
    }

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookingDetail> bookingDetails;
}