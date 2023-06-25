/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Videogames.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author arianasaboriom
 */
@Data
@Entity
@Table(name="product")
public class Product implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long idProduct;
    private String category;
    private String product_name;
    private String description;
    private float price;
    private String rutaImagen;

    public Product(){}
    
    public Product(Long idProduct, String category, String product_name, String description, float price, String rutaImagen) {
        this.idProduct = idProduct;
        this.category = category;
        this.product_name = product_name;
        this.description = description;
        this.price = price;
        this.rutaImagen = rutaImagen;
        
    }

    
    

    
}
