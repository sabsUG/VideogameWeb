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
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author arianasaboriom
 */
@Data
@Entity
@Table(name="job")
public class Job implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long idJob;
    private String category;
    private String job_name;
    private String type;
    private String level;
    private String skills;
    private String tools_needed;
    private String description;
    private String salary;
   
    public Job(){}

    public Job(Long idJob, String category, String job_name, String type, String level, String skills, String tools_needed, String description, String salary) {
        this.idJob = idJob;
        this.category = category;
        this.job_name = job_name;
        this.type = type;
        this.level = level;
        this.skills = skills;
        this.tools_needed = tools_needed;
        this.description = description;
        this.salary = salary;
    }
    
    
      
}
