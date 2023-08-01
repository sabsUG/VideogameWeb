/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Videogames.dao;

import com.Videogames.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author arianasaboriom
 */
public interface RolDao extends JpaRepository<Rol, Long>{
    
}
