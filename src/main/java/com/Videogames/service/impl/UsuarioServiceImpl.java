/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Videogames.service.impl;

import com.Videogames.dao.RolDao;
import com.Videogames.dao.UsuarioDao;
import com.Videogames.domain.Rol;
import com.Videogames.domain.Usuario;
import com.Videogames.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author arianasaboriom
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private RolDao rolDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioByUsername(String username) {
        return usuarioDao.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioByUsernameAndPassword(String username, String password) {
        return usuarioDao.findByUsernameAndPassword(username, password);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioByUsernameOrEmail(String username, String email) {
        return usuarioDao.findByUsernameOrEmail(username, email);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeUsuarioByUsernameOrEmail(String username, String email) {
        return usuarioDao.existsByUsernameOrEmail(username, email);
    }

    @Override
    @Transactional
    public void save(Usuario usuario, boolean crearRolUser) {
        System.out.println(usuario.getUsername());
        usuario=usuarioDao.save(usuario);
        System.out.println(usuario.getUsername());
        if (crearRolUser) {  //Si se está creando el usuario, se crea el rol por defecto "USER"
            Rol rol = new Rol();
            rol.setName("ROLE_BASIC");
            rol.setUsername(usuario.getUsername());
            rolDao.save(rol);
        }
        System.out.println("ROLE SAVED");
    }
    
    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }
    
}
