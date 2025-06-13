package com.codegym.hotelmanagement.model;

import javax.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;

    @Column(unique = true,name = "room_number")
    private String roomNumber;

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    private List<BookingDetail> bookingDetails;

    @Enumerated(EnumType.STRING)
    private RoomStatus status;

    public enum RoomStatus {
        Available, Occupied, Maintenance
    }
}