package com.Videogames.dao;

import com.Videogames.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);

    Usuario findByUsernameAndPassword(String username, String Password);

    Usuario findByUsernameOrEmail(String username, String correo);

    boolean existsByUsernameOrEmail(String username, String correo);
    
}
