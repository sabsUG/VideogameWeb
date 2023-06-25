/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Videogames.service.impl;

import com.Videogames.dao.JobDao;
import com.Videogames.domain.Job;
import com.Videogames.service.JobService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author arianasaboriom
 */
@Service
public class JobServiceImpl implements JobService{

    @Autowired
    private JobDao jobDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Job> getJobs() {
        var list=jobDao.findAll();
        
        return list;
    }

    @Override
    @Transactional(readOnly=true)
    public Job getJob(Job job) {
        return jobDao.findById(job.getIdJob()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Job job) {
        jobDao.save(job);
    }

    @Override
    @Transactional
    public void delete(Job job) {
        jobDao.delete(job);
    }
    
}
