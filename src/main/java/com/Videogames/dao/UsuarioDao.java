package com.Videogames.dao;

import com.Videogames.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, String> {

    Usuario findByUsername(String username);

    
    
}
