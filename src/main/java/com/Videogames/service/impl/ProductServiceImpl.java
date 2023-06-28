/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Videogames.service.impl;

import com.Videogames.dao.ProductDao;
import com.Videogames.domain.Product;
import com.Videogames.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author arianasaboriom
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Product> getProducts() {
        var list=productDao.findAll();
        
        return list;
    }

    @Override
    @Transactional(readOnly=true)
    public Product getProduct(Product product) {
        return productDao.findById(product.getIdProduct()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    @Transactional
    public void delete(Product product) {
        productDao.delete(product);
    }

    
    
}
