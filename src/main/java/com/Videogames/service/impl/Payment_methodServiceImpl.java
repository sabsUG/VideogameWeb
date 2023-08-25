package com.Videogames.service.impl;

import com.Videogames.dao.Payment_methodDao;
import com.Videogames.domain.Payment_method;
import com.Videogames.service.Payment_methodService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Payment_methodServiceImpl implements Payment_methodService{

    @Autowired
    private Payment_methodDao payment_methodDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Payment_method> getPayment_methods() {
        var list=payment_methodDao.findAll();
        
        return list;
    }

    @Override
    @Transactional(readOnly=true)
    public Payment_method getPayment_method(Payment_method payment_method) {
        return payment_methodDao.findById(payment_method.getIdPayment_method()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Payment_method payment_method) {
        payment_methodDao.save(payment_method);
    }

    @Override
    @Transactional
    public void delete(Payment_method payment_method) {
        payment_methodDao.delete(payment_method);
    }

    
    
}
