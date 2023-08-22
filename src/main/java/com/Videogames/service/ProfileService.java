/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Videogames.service;

import com.Videogames.domain.Usuario;
import java.util.List;

/**
 *
 * @author kevin
 */
public interface ProfileService {

    public List<Usuario> getUsuarios();

    // Se obtiene un Usuario, a partir del id de un usuario
    public Usuario getUsuarioByUsername(String username);

    boolean cambiarEmail(String username, String nuevoEmail);

    String obtenerNombreUsuario(String username);

    Usuario actualizarUsuario(Usuario usuario);

    
}
