package com.codegym.hotelmanagement.model;

import javax.persistence.*;
import lombok.*;
import org.hashids.Hashids;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDetail {

    @Id
    private String bookingDetailId;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @PrePersist
    public void generateId() {
        if (this.bookingDetailId == null || this.bookingDetailId.isEmpty()) {
            this.bookingDetailId = IdGenerator.generate();
        }
    }

    private static class IdGenerator {
        private static final Hashids hashids = new Hashids("booking-detail-salt", 6);
        private static long lastTime = System.currentTimeMillis();
        private static int counter = 0;

        public static synchronized String generate() {
            long now = System.currentTimeMillis();
            if (now == lastTime) {
                counter++;
            } else {
                lastTime = now;
                counter = 0;
            }
            long numberToEncode = now * 100 + counter; // đảm bảo duy nhất từng ms
            return hashids.encode(numberToEncode).toUpperCase();
        }
    }
}