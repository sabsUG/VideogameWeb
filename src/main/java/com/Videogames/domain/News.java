/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Videogames.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 *
 * @author arianasaboriom
 */
@Data
@Entity
@Table(name="new")
public class News {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long idNews;
    private String Title;
    private String number;
    private String Description;
   
    public News(){}

    public News(Long idNews, String Title, String number, String Description) {
        this.idNews = idNews;
        this.Title = Title;
        this.number = number;
        this.Description = Description;
    }
    
    
}
