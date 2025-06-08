package com.codegym.hotelmanagement.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer staffId;

    private String fullName;

    @Column(unique = true)
    private String username;

    private String passwordHash;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        Admin, Receptionist
    }
}