package com.Videogames.service;

import com.Videogames.domain.Payment_method;
import java.util.List;

public interface Payment_methodService {
    
    public List<Payment_method> getPayment_methods();
    
    public Payment_method getPayment_method(Payment_method payment_method);
    
    public void save(Payment_method payment_method);
    
    public void delete(Payment_method payment_method);
}
