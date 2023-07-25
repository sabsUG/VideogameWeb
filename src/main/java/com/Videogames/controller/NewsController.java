/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Videogames.controller;

import com.Videogames.domain.News;
import com.Videogames.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author arianasaboriom
 */
@Controller
@Slf4j
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    
    @GetMapping("/listed")
    public String begin(Model model) {
        var news = newsService.getNews();
        model.addAttribute("news", news);
        model.addAttribute("totalNews", news.size());
        return "/news/listed";
    }
    
    
    @GetMapping("/news")
    public String newNews(News news) {
        return "/news/edit";
    }

    /*
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/save")
    public String saveJob(Job job,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            jobService.save(job);
            job.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "job", 
                            job.getIdJob()));
        }
        jobService.save(product);
        return "redirect:/job/listed";
    }
*/

    @GetMapping("/delete/{idNews}")
    public String deleteNews(News news) {
        newsService.delete(news);
        return "redirect:/news/listed";
    }

    @GetMapping("/edit/{idNews}")
    public String editNews(News news, Model model) {
        news = newsService.getNews(news);
        model.addAttribute("news", news);
        return "/news/edit";
    }

}
