package com.Videogames.service.impl;

import com.Videogames.dao.UsuarioDao;
import com.Videogames.domain.Usuario;
import com.Videogames.domain.Rol;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Videogames.service.UsuarioDetailsService;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService {

    @Autowired

    private UsuarioDao usuarioDao;

    @Autowired

    private HttpSession session;
        @Override

    @Transactional(readOnly = true)

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //Busca el usuario por el username en la tabla

        Usuario usuario = usuarioDao.findByUsername(username);
        
        System.out.println(usuario.getName());
        System.out.println(usuario.getPassword());

        //Si no existe el usuario lanza una excepción

        if (usuario == null) {

            throw new UsernameNotFoundException(username);

        }

        //session.removeAttribute("usuarioImagen");

        //session.setAttribute("usuarioImagen", usuario.getRutaImagen());

        //Si está acá es porque existe el usuario... sacamos los roles que tiene

        var roles = new ArrayList<GrantedAuthority>();

        for (Rol rol : usuario.getRoles()) {   //Se sacan los roles
            
            System.out.println(rol.getName());
            roles.add(new SimpleGrantedAuthority(rol.getName()));

        }

        //Se devuelve User (clase de userDetails)

        return new User(usuario.getUsername(), usuario.getPassword(), roles);

    }


}

