package com.Videogames.service;

import com.Videogames.domain.Order;
import java.util.List;

public interface OrderService {
     
    public List<Order> getOrders();
    
    public Order getOrder(Order order);
    
    public void save(Order order);
    
    public void delete(Order order);
}
