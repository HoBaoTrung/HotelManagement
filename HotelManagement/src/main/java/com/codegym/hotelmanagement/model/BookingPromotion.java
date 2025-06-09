package com.codegym.hotelmanagement.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(BookingPromotionId.class)
public class BookingPromotion {

    @Id
    @Column(name = "booking_id")
    private Integer bookingId;

    @Id
    @Column(name = "promotion_id")
    private Integer promotionId;

    @ManyToOne
    @JoinColumn(name = "booking_id", insertable = false, updatable = false)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "promotion_id", insertable = false, updatable = false)
    private Promotion promotion;
}