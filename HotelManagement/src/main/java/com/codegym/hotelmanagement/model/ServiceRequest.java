package com.codegym.hotelmanagement.model;

import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceRequest  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer requestId;

    @ManyToOne
    @JoinColumn(name = "room_access_code")
    private RoomAccessCode roomAccessCode;

    @OneToMany(mappedBy = "serviceRequest")
    private List<ServiceRequestDetail> serviceRequestDetails;

    private LocalDateTime requestTime;
    private String note;
}