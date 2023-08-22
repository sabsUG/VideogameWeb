/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Videogames.dao;

/**
 *
 * @author kevin
 */
import com.Videogames.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileDao extends JpaRepository <Usuario,Long>{
    
}
