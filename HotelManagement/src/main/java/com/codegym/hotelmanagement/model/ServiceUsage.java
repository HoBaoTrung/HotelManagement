package com.codegym.hotelmanagement.model;

import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usageId;

    @ManyToOne
    @JoinColumn(name = "booking_detail_id")
    private BookingDetail bookingDetail;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    private Integer quantity;
    private LocalDateTime usageTime;
    private String note;
}