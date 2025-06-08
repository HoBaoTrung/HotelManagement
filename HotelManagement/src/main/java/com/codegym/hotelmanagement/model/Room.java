package com.codegym.hotelmanagement.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Integer roomId;

    @Column(unique = true,name = "room_number")
    private String roomNumber;

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

    @Enumerated(EnumType.STRING)
    private RoomStatus status;

    public enum RoomStatus {
        Available, Occupied, Maintenance
    }
}