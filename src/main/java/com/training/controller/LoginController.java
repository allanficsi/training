package com.training.controller;

import com.training.model.topico.dto.TopicoDTO;
import com.training.model.topico.entity.Topico;
import com.training.security.JwtRequest;
import com.training.security.JwtResponse;
import com.training.security.util.JwtTokenUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginController
{


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private  AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil tokenService;

    @PostMapping //define um id para esse cache
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest usuario)
    {
         UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(usuario.getLogin(),usuario.getSenha());

         Authentication authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
         String tokeJwt = tokenService.generateToken(authenticate);

         JwtResponse jwtResponse = new JwtResponse(authenticate.getName(),tokeJwt);

         return  ResponseEntity.ok(jwtResponse);
    }

    private Object atualizarEntidadeResponse(Topico topico)
    {
        return convertToDto(topico);
    }

    private Page<Object> atualizarListaResponse(Page<Topico> topicoList)
    {
        return topicoList.map(topico -> convertToDto(topico));
    }

    private TopicoDTO convertToDto(Topico topico)
    {
        TopicoDTO dto = new TopicoDTO();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.map(topico, dto);

        return dto;
    }
}
