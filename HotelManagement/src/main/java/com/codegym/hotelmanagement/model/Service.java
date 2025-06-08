package com.codegym.hotelmanagement.model;

import javax.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceId;

    private String serviceName;
    private BigDecimal price;
    private String unit;

    @ManyToOne
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType;
}