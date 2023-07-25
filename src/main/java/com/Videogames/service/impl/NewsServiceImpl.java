/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Videogames.service.impl;

import com.Videogames.dao.NewsDao;
import com.Videogames.domain.News;
import com.Videogames.service.NewsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author arianasaboriom
 */
@Service
public class NewsServiceImpl implements NewsService{

    @Autowired
    private NewsDao newsDao;
    
    
    
    @Override
    @Transactional(readOnly=true)
    public List<News> getNews() {
        var list=newsDao.findAll();
        
        return list;
    }

    @Override
    @Transactional(readOnly=true)
    public News getNews(News news) {
        return newsDao.findById(news.getIdNews()).orElse(null);
    }

    @Override
    public void save(News news) {
        newsDao.save(news);
    }

    @Override
    public void delete(News news) {
        newsDao.delete(news);
    }
    
}
