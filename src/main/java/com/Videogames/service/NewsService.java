/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Videogames.service;

import com.Videogames.domain.News;
import java.util.List;

/**
 *
 * @author arianasaboriom
 */
public interface NewsService {
    
    public List<News> getNews();
    
    public News getNews(News news);
    
    public void save(News news);
    
    public void delete(News news);
}
