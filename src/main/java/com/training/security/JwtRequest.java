package com.training.security;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class JwtRequest
{
    @NotEmpty @NotNull
    private String login;

    @NotEmpty @NotNull
    private String Senha;

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getSenha()
    {
        return Senha;
    }

    public void setSenha(String senha)
    {
        Senha = senha;
    }
}
