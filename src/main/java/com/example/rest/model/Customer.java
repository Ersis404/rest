package com.example.rest.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String middlename;
    private String adres;
    private String email;
    private String phone;
    @OneToMany(mappedBy ="customer", fetch = FetchType.LAZY)
    private List<Order> orders;
}
