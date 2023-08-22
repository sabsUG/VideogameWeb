/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Videogames.controller;

import com.Videogames.domain.Usuario;
import com.Videogames.service.FirebaseStorageService;
import com.Videogames.service.ProfileService;
import com.Videogames.service.UsuarioService;
import java.security.Principal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/profile")

public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/Profile")
    public String showProfile(Model model, Principal principal) {
        String loggedInUsername = principal.getName(); // Obtiene el nombre de usuario del usuario logueado
        Usuario usuario = profileService.getUsuarioByUsername(loggedInUsername);
        model.addAttribute("usuario", usuario);

        String nombreUsuario = profileService.obtenerNombreUsuario(loggedInUsername);
        model.addAttribute("nombreUsuario", nombreUsuario);

        return "profile/Profile"; 
    }

    @GetMapping("/ChangeEmail")
    public String ChangeEmail(Model model) {
        return "profile/ChangeEmail"; 
    }

    @GetMapping("/ChangePassword")
    public String ChangePassword(Model model) {
        return "profile/ChangePassword"; 
    }

    @GetMapping("/UploadResume")
    public String UploadResume(Model model) {
        return "profile/UploadResume"; //
    }

    @GetMapping("/PaymentMethod")
    public String PaymentMethod(Model model) {
        return "profile/PaymentMethod";
    }

    @PostMapping("/ChangeEmail")
    public String ChangeEmail(@RequestParam String oldEmail, @RequestParam String newEmail, Principal principal) {
        String loggedInUsername = principal.getName();
        profileService.cambiarEmail(loggedInUsername, newEmail);
        return "redirect:/profile/Profile";
    }

    @PostMapping("/ChangePassword")
public String changePassword(@RequestParam String oldPassword, @RequestParam String newPassword, 
                             @RequestParam String confirmPassword, Principal principal) {
    String loggedInUsername = principal.getName();
    
    // Obtén el usuario de la base de datos
    Usuario usuario = profileService.getUsuarioByUsername(loggedInUsername);
    
    // Implementa la lógica para validar la contraseña actual y la confirmación
    if (!usuario.getPassword().equals(oldPassword) || !newPassword.equals(confirmPassword)) {
        // Manejo de errores, redirección con mensaje, etc.
        return "redirect:/profile/ChangePassword";
    }
    
    // Actualiza la contraseña del usuario en la entidad
    usuario.setPassword(newPassword);
    
    // Actualiza el usuario en la base de datos
    profileService.actualizarUsuario(usuario);
    
    return "redirect:/profile/Profile"; // Redirige después de cambiar la contraseña
}
}
