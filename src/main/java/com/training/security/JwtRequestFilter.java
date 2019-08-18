package com.training.security;

import com.training.security.util.JwtTokenUtil;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * filtro que vai ser chamado antes de chegar em qualquer controller
 * pra verificar a existencia do token e valida-lo
 */

public class JwtRequestFilter extends OncePerRequestFilter
{
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailService jwtUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        String token = this.jwtTokenUtil.getTokenFromHeader(request);

        if (!(token == null))
        {
            String login = this.jwtTokenUtil.getUsernameFromToken(token);
            UserDetails userDetails = jwtUserDetailService.loadUserByUsername(login);
            Boolean valid = this.jwtTokenUtil.isValidToken(token, userDetails);

            if (valid)
            {
                this.userAuthentication(token);
            }
        }

        filterChain.doFilter(request, response);
    }


    /**
     * como o token já foi autenticado e validado
     * é nescessario falar ao spring que esse usuario é valido e que essa requisacao
     * pode ser processada, como  ele logou foi dado a ele o token é ele que confima
     * o usuario sem a nescessidade e refazer login e senha
     */
    private void userAuthentication(String token)
    {
        String usuarioLogin = this.jwtTokenUtil.getUsernameFromToken(token);
        JwtUserDetail usuario = (JwtUserDetail) this.jwtUserDetailService.loadUserByUsername(usuarioLogin);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(usuario.getUsername(), null, usuario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
    }
}
