package com.training.security;

import com.training.model.usuario.entity.Usuario;
import com.training.model.usuario.service.UsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailService implements UserDetailsService
{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        Optional<Usuario> usuario = this.usuarioRepository.findByEmail(email);

        if (usuario.isPresent())
        {
            Usuario usuarioLogado = usuario.get();

            JwtUserDetail jwtUserDetail = new JwtUserDetail(usuarioLogado.getCodigo(), usuarioLogado.getEmail(), usuarioLogado.getSenha(), usuarioLogado.getUsuariosPerfis());
            return jwtUserDetail;
        }

        throw new UsernameNotFoundException("Usuario ou Senha inválidos");
    }
}
