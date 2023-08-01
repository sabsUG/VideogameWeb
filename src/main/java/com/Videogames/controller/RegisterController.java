/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Videogames.controller;

import com.Videogames.domain.Usuario;
import com.Videogames.service.RegisterService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author arianasaboriom
 */
@Controller
@Slf4j
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @GetMapping("/nuevo")
    public String nuevo(Model model, Usuario usuario) {
        return "/register/nuevo";
    }

    @GetMapping("/recordar")
    public String recordar(Model model, Usuario usuario) {
        return "/register/recordar";
    }

    @PostMapping("/crearUsuario")
    public String crearUsuario(Model model, Usuario usuario) 
            throws MessagingException {
        model = registerService.crearUsuario(model, usuario);
        return "/register/salida";
    }

    @GetMapping("/activacion/{usuario}/{id}")
    public String activar(
            Model model, 
            @PathVariable(value = "usuario") String usuario, 
            @PathVariable(value = "id") String id) {
        System.out.println("HERE");
        model = registerService.activar(model, usuario, id);
        if (model.containsAttribute("usuario")) {
            return "/register/activa";
        } else {
            return "/register/salida";
        }
    }

    @PostMapping("/activar")
    public String activar(
            Usuario usuario) {
        System.out.println("HERE");
        registerService.activar(usuario);
        
        return "redirect:/";
    }

    @PostMapping("/recordarUsuario")
    public String recordarUsuario(Model model, Usuario usuario) 
            throws MessagingException {
        model = registerService.recordarUsuario(model, usuario);
        return "/register/salida";
    }
}
