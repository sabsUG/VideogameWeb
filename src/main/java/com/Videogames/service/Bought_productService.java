package com.Videogames.service;

import com.Videogames.domain.Bought_product;
import java.util.List;

public interface Bought_productService {
     
    public List<Bought_product> getBought_products();
    
    public Bought_product getBought_product(Bought_product bought_product);
    
    public void save(Bought_product bought_product);
    
    public void delete(Bought_product bought_product);
}
