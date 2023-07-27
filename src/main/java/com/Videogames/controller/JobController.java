/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Videogames.controller;

import com.Videogames.domain.Job;
import com.Videogames.service.JobService;
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
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/listed")
    public String begin(Model model) {
        var jobs = jobService.getJobs();
        model.addAttribute("jobs", jobs);
        model.addAttribute("totalJobs", jobs.size());
        return "/job/listed";
    }
    
    
    @GetMapping("/new")
    public String newJob(Job job) {
        return "/job/edit";
    }
    
    
    @GetMapping("/Designers")
    public String getDesigners(Model model) {
        var jobs = jobService.getJobs();
        model.addAttribute("jobs", jobs);
        model.addAttribute("totalJobs", jobs.size());
        return "/job/Designers";
    }
    
    
    @GetMapping("/Unity")
    public String getUnity(Model model) {
        var jobs = jobService.getJobs();
        model.addAttribute("jobs", jobs);
        model.addAttribute("totalJobs", jobs.size());
        return "/job/Unity";
    }
    
    @GetMapping("/FrontEnd")
    public String getFrontEnd(Model model) {
        var jobs = jobService.getJobs();
        model.addAttribute("jobs", jobs);
        model.addAttribute("totalJobs", jobs.size());
        return "/job/FrontEnd";
    }
    
    @GetMapping("/Ios")
    public String getIos(Model model) {
        var jobs = jobService.getJobs();
        model.addAttribute("jobs", jobs);
        model.addAttribute("totalJobs", jobs.size());
        return "/job/Ios";
    }
    
    @GetMapping("/Android")
    public String getAndroid(Model model) {
        var jobs = jobService.getJobs();
        model.addAttribute("jobs", jobs);
        model.addAttribute("totalJobs", jobs.size());
        return "/job/Android";
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

    @GetMapping("/delete/{idJob}")
    public String deleteJob(Job job) {
        jobService.delete(job);
        return "redirect:/job/listed";
    }

    @GetMapping("/edit/{idJob}")
    public String editJob(Job job, Model model) {
        job = jobService.getJob(job);
        model.addAttribute("job", job);
        return "/job/edit";
    }
}
