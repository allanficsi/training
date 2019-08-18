package com.training.security.util;

import com.training.security.JwtUserDetail;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.function.Function;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil
{
    @Value("${training.jwt.experition}")
    private String expirationTime;

    @Value("${training.jwt.secret}")
    private String secret;

    public String generateToken(Authentication authenticate)
    {
        JwtUserDetail usuario = (JwtUserDetail) authenticate.getPrincipal();
        Date hoje = new Date();
        Date dataDeExpiracaoToken = new Date(hoje.getTime() + Long.parseLong(this.expirationTime));

        return Jwts.builder()
                .setIssuer("training_api")//nome da aplicacao
                .setSubject(usuario.getUsername())//string que define o dono do token, tem que ser algo que idetifique de forma unica o usuario, login por exemplo
                .setIssuedAt(hoje)//data de criacao do token
                .setExpiration(dataDeExpiracaoToken)//quando o token vai expirar
                .signWith(SignatureAlgorithm.HS256, this.secret)
                .compact();
    }

    public String getTokenFromHeader(HttpServletRequest request)
    {
        String token = request.getHeader("Authorization");

        if (token == null || token.isEmpty() || !token.startsWith("Bearer "))
        {
            return null;
        }

        try
        {
            this.getAllClaimsFromToken(token.substring(7, token.length()));
        }
        catch (Exception e)
        {
            return null;
        }

        return token.substring(7, token.length());
    }

    public String getUsernameFromToken(String token)
    {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token)
    {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver)
    {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    //recupera todos os claim from token

    private Claims getAllClaimsFromToken(String token)
    {
        return Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token)
    {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public Boolean isValidToken(String token, UserDetails userDetails)
    {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
