package com.codegym.hotelmanagement.model;

import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingPromotionId implements Serializable {
    private Integer bookingId;
    private Integer promotionId;
}