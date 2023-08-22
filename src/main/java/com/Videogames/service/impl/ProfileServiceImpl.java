/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Videogames.service.impl;

/**
 *
 * @author kevin
 */
import com.Videogames.dao.RolDao;
import com.Videogames.dao.UsuarioDao;
import com.Videogames.domain.Rol;
import com.Videogames.domain.Usuario;
import com.Videogames.service.UsuarioService;
import com.Videogames.service.ProfileService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private RolDao rolDao;
    private List<Usuario> usuarios; 

    public ProfileServiceImpl(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    @Override
    public Usuario getUsuarioByUsername(String username) {
        // Implementación para buscar y devolver un usuario por su nombre de usuario
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    @Transactional
    public boolean cambiarEmail(String username, String nuevoEmail) {
        Usuario usuario = getUsuarioByUsername(username);
        if (usuario != null) {
            usuario.setEmail(nuevoEmail);
            usuarioDao.save(usuario); // Actualiza el correo electrónico en la base de datos
            return true;
        }
        return false; 
    }

    @Override
    public String obtenerNombreUsuario(String username) {
        Usuario usuario = getUsuarioByUsername(username);
        if (usuario != null) {
            return usuario.getName(); // Devolver el nombre del usuario
        }
        return null; 
    }
    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioDao.save(usuario);
    }
}
