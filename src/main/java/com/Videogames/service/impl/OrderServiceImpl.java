package com.Videogames.service.impl;

import com.Videogames.dao.OrderDao;
import com.Videogames.domain.Order;
import com.Videogames.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Order> getOrders() {
        var list=orderDao.findAll();
        
        return list;
    }

    @Override
    @Transactional(readOnly=true)
    public Order getOrder(Order order) {
        return orderDao.findById(order.getIdOrder()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Order order) {
        orderDao.save(order);
    }

    @Override
    @Transactional
    public void delete(Order order) {
        orderDao.delete(order);
    }
    
}
