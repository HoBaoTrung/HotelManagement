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
    @Column(name = "room_type_id")
    private Integer roomTypeId;

    @Column(name = "type_name")
    private String typeName;
    private BigDecimal price;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Integer capacity;

    @OneToMany(mappedBy = "roomType",
            fetch = FetchType.LAZY)
    private Set<Room> rooms;
}