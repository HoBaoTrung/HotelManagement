package com.codegym.hotelmanagement.model;

import javax.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomTypeId;

    private String typeName;
    private BigDecimal price;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Integer capacity;

    private String imageURL;

    @OneToMany(mappedBy = "roomType",
            fetch = FetchType.LAZY)
    private Set<Room> rooms;
}