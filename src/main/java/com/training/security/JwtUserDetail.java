package com.training.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.training.model.usuario.entity.UsuariosPerfis;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * o spring obriga vc a ter uma classe que representa
 * um usuario para isso é nescessario implementar a interface UserDetail
 */


public class JwtUserDetail  implements UserDetails
{

    private final Long id;

    private final String username;

    @JsonIgnore
    private final String password;

    private final Set<UsuariosPerfis>  usuariosPerfis;

    public JwtUserDetail(Long id, String username, String password, Set<UsuariosPerfis> usuariosPerfis)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.usuariosPerfis = usuariosPerfis;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return this.usuariosPerfis.stream().map(UsuariosPerfis::getPerfil).collect(Collectors.toSet());

    }

    public Long getId()
    {
        return id;
    }

    public Set<UsuariosPerfis> getUsuariosPerfis()
    {
        return usuariosPerfis;
    }

    @Override
    public String getPassword()
    {
        return this.password;
    }

    @Override
    public String getUsername()
    {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }
}
