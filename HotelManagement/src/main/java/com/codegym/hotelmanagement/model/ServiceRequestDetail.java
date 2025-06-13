package com.codegym.hotelmanagement.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceRequestDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestDetailId;

    @ManyToOne
    @JoinColumn(nullable = false, name = "service_request_id")
    private ServiceRequest serviceRequest;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @Column(nullable = false)
    private int quantity;

    @Column(insertable = false, updatable = false)
    private double price;
}
