package com.Videogames.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
@Entity

@Data

@Table(name="user")

public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
 
    @Column(unique = true)
    private Long Id;    

    @Id
    private String username;    

    @NotEmpty
    private String password;

    private String name;

    private String email;

    private String address;
    

    @OneToMany
    @JoinColumn(name="username")
    private List<Rol> roles;
}