/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Videogames.service;

import com.Videogames.domain.Usuario;
import java.util.List;

/**
 *
 * @author arianasaboriom
 */
public interface UsuarioService {
    // Se obtiene un listado de usuarios en un List
    public List<Usuario> getUsuarios();
    
    // Se obtiene un Usuario, a partir del id de un usuario
    public Usuario getUsuario(Usuario usuario);
    
    // Se obtiene un Usuario, a partir del username de un usuario
    public Usuario getUsuarioByUsername(String username);

    // Se obtiene un Usuario, a partir del username y el password de un usuario
    public Usuario getUsuarioByUsernameAndPassword(String username, String password);
    
    // Se obtiene un Usuario, a partir del username y el password de un usuario
    public Usuario getUsuarioByUsernameOrEmail(String username, String email);
    
    // Se valida si existe un Usuario considerando el username
    public boolean existeUsuarioByUsernameOrEmail(String username, String email);
    
    // Se inserta un nuevo usuario si el id del usuario esta vacío
    // Se actualiza un usuario si el id del usuario NO esta vacío
    public void save(Usuario usuario,boolean crearRolUser);
    
    // Se elimina el usuario que tiene el id pasado por parámetro
    public void delete(Usuario usuario);
    
}
