/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Videogames.service;

import com.Videogames.domain.Job;
import java.util.List;

/**
 *
 * @author arianasaboriom
 */
public interface JobService {
     
    public List<Job> getJobs();
    
    public Job getJob(Job job);
    
    public void save(Job job);
    
    public void delete(Job job);
}
