package com.codegym.hotelmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceTypeId;

    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceType", fetch = FetchType.LAZY)
    private List<Service> services;
}
