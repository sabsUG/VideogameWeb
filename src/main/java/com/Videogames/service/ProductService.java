/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Videogames.service;

import com.Videogames.domain.Product;
import java.util.List;

/**
 *
 * @author arianasaboriom
 */
public interface ProductService {
    
    public List<Product> getProducts();
    
    
    
    public Product getProduct(Product product);
    
    public void save(Product product);
    
    public void delete(Product product);
}
