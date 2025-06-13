package com.codegym.hotelmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hashids.Hashids;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomAccessCode {

        @Id
        @Column(name = "code_id", unique = true)
        private String codeId;

        @OneToOne
        @JoinColumn(name = "booking_detail_id", unique = true)
        private BookingDetail bookingDetail;

        @Column(name = "is_active")
        private boolean isActive = true;

        @Column(name = "issued_at")
        @Temporal(TemporalType.TIMESTAMP)
        private Date issuedAt;

        @PrePersist
        public void prePersist() {
            if (this.codeId == null || this.codeId.isEmpty()) {
                this.codeId = IdGenerator.generate();
            }
            if (this.issuedAt == null) {
                this.issuedAt = new Date();
            }
        }

        private static class IdGenerator {
            private static final Hashids hashids = new Hashids("booking-detail-salt", 8);

            public static synchronized String generate() {
                return hashids.encode(System.nanoTime()).toUpperCase();
            }
        }

}
