package com.ex.demo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "first_name")
    private String fisrtname;
    private String address;
    private String city;
    private int age;

}
