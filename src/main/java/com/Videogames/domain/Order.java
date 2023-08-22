package com.Videogames.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;
import lombok.Data;

@Data
@Entity
@Table(name="order")
public class Order implements Serializable {    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long idOrder;
    private String username;
    private Date date_ordered;    
    private double total_paid;
    private int product_quantity;
    private String payment_method_used;
    
    public Order() {
    }

    public Order(String username) {
        this.username = username;
        this.date_ordered = Calendar.getInstance().getTime();
    }

    
}
