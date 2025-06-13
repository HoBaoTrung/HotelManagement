package com.codegym.hotelmanagement.model;
import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int depositId;

    @ManyToOne
    private Booking booking;

    private Double amount;

    @ManyToOne
    private PaymentMethod paymentMethod;

    @Temporal(TemporalType.TIMESTAMP)
    private Date depositTime = new Date();

    @Column(name = "percentage")
    @DecimalMin(value = "0.0")
    @DecimalMax(value = "1.0")
    private BigDecimal percentage;

    private String note;
}
