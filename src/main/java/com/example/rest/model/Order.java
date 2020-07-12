package com.example.rest.model;



import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate order_date;
    @Enumerated(EnumType.STRING)
    private Order_status order_status;
    @Enumerated(EnumType.STRING)
    private Payment_method payment_method;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    @OneToMany(mappedBy ="order", fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetailList;
}
