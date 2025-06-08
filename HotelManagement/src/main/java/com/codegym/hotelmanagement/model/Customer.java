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
    @Column(unique = true, nullable = false, name = "customer_id")
    private Integer customerId;

    @Column(name = "full_name")
    private String fullName;
    private String phone;
    private String email;

    @Column(name = "id_card")
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