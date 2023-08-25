package com.Videogames.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import lombok.Data;

@Data
@Entity
@Table(name="payment_method")
public class Payment_method implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long idPayment_method;
    private String name_on_card;
    private String alias_card;
    private String username;
    private String address1;
    private String address2;
    private String card_number;
    private String cvv;
    private Date expiry_date;

    public Payment_method(){}

    public Payment_method(String name_on_card, String alias_card, String username, String address1, String address2, String card_number, String cvv, Date expiry_date) {
        this.name_on_card = name_on_card;
        this.alias_card = alias_card;
        this.username = username;
        this.address1 = address1;
        this.address2 = address2;
        this.card_number = card_number;
        this.cvv = cvv;
        this.expiry_date = expiry_date;
    }

    
    
}
