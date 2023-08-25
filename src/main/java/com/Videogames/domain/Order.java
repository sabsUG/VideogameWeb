package com.Videogames.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name="orders")
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

    public Order(Date date_ordered, String payment_method_used,  int product_quantity, double total_paid, String username) {
        this.username = username;
        this.date_ordered = date_ordered;
        this.total_paid = total_paid;
        this.product_quantity = product_quantity;
        this.payment_method_used = payment_method_used;
    }
    
    
    
}
