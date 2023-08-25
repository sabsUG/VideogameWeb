package com.Videogames.service.impl;

import com.Videogames.dao.Bought_productDao;
import com.Videogames.domain.Bought_product;
import com.Videogames.service.Bought_productService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Bought_productServiceImpl implements Bought_productService{

    @Autowired
    private Bought_productDao bought_productDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Bought_product> getBought_products() {
        
        var list=bought_productDao.findAll();
        return list;
    }

    @Override
    @Transactional(readOnly=true)
    public Bought_product getBought_product(Bought_product bought_product) {
        return bought_productDao.findById(bought_product.getIdBought_product()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Bought_product bought_product) {
        bought_productDao.save(bought_product);
    }

    @Override
    @Transactional
    public void delete(Bought_product bought_product) {
        bought_productDao.delete(bought_product);
    }
    
}
