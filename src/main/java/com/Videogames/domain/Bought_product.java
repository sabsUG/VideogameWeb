package com.Videogames.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="bought_product")
public class Bought_product implements Serializable {    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long idBought_product;
    private Long order_id;
    private Long product_id;
    private int product_quantity;
    
    public Bought_product() {
    }

    public Bought_product(Long order_id, Long product_id, int product_quantity) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.product_quantity = product_quantity;
    }

    
}
