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
    private Integer bookingId;

    @Id
    private Integer promotionId;

    @ManyToOne
    @JoinColumn(name = "booking_id", insertable = false, updatable = false)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "promotion_id", insertable = false, updatable = false)
    private Promotion promotion;
}