package com.Videogames.dao;

import com.Videogames.domain.Payment_method;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Payment_methodDao extends JpaRepository <Payment_method,Long>{
    
}
