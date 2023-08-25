/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Videogames.controller;

import com.Videogames.domain.Usuario;
import com.Videogames.service.FirebaseStorageService;
import com.Videogames.service.ItemService;
import com.Videogames.service.OrderService;
import com.Videogames.service.Payment_methodService;
import com.Videogames.service.ProductService;
import com.Videogames.service.ProfileService;
import com.Videogames.service.UsuarioService;
import java.security.Principal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/profile")

public class ProfileController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private Payment_methodService payment_methodService;


    @Autowired
    private OrderService orderService;
    @Autowired
    private ProfileService profileService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/Profile")
    public String showProfile(Model model, Principal principal) {
        String loggedInUsername = principal.getName();
        Usuario usuario = profileService.getUsuarioByUsername(loggedInUsername);
        model.addAttribute("usuario", usuario);
        return "profile/Profile";
    }

    /*@GetMapping("/ChangeEmail")
    public String changeEmail(Model model, Principal principal) {
        String loggedInUsername = principal.getName(); // Obtiene el nombre de usuario del usuario logueado
        Usuario usuario = usuarioService.getUsuarioByUsername(loggedInUsername);
        model.addAttribute("usuario", usuario);
        return "profile/ChangeEmail";
    }*/

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
        Usuario user2 = itemService.getUser();
        String username = user2.getUsername();
        var payment_methods = payment_methodService.getPayment_methods();
        model.addAttribute("usuario", username);
        model.addAttribute("payment_methods", payment_methods);
        return "profile/PaymentMethod";
    }

    @GetMapping("/YourOrders")
    public String YourOrders(Model model) {
        Usuario user2 = itemService.getUser();
        String username = user2.getUsername();
        var orders = orderService.getOrders();
        model.addAttribute("usuario", username);
        model.addAttribute("orders", orders);
        return "profile/YourOrders";
    } 
    @GetMapping("/ChangeEmail")
    public String processChangeEmail(Model model) {
        Usuario usuario = profileService.getUser();
        model.addAttribute("usuario", usuario);
        return "profile/ChangeEmail"; 
    }
    @PostMapping("/ChangeEmailNew")
    public String processChangeEmailNew(Usuario usuario){
            usuarioService.save(usuario, false);
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
