package com.codegym.hotelmanagement.model;

import javax.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    private String fullName;
    private String phone;
    private String email;

    private String idCard;
    private String address;
    private String nationality;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate dob;

    public enum Gender {
        Male, Female, Other
    }
}