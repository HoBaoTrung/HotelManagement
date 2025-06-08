package com.codegym.hotelmanagement.model;

import javax.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer promotionId;

    @Column(unique = true)
    private String code;

    @Column(columnDefinition = "TEXT")
    private String description;

    private BigDecimal discountPercent;
    private LocalDate validFrom;
    private LocalDate validTo;
    private Boolean active;
}