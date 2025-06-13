package com.codegym.hotelmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StayType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stayTypeId;

    @Enumerated(EnumType.STRING)
    private StayName stayName;

    public enum StayName {
        Hourly, Overnight, Daily
    }

    private Double defaultPrice;

}
