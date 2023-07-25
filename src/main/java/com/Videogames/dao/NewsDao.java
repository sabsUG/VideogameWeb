/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Videogames.dao;

import com.Videogames.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author arianasaboriom
 */
public interface NewsDao extends JpaRepository <News,Long>{
    
}
