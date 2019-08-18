package com.training.security;

public class JwtResponse
{

    private String login;

    private String tokenJwt;

    public JwtResponse(String login, String tokenJwt)
    {
        this.login = login;
        this.tokenJwt = tokenJwt;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getTokenJwt()
    {
        return tokenJwt;
    }

    public void setTokenJwt(String tokenJwt)
    {
        this.tokenJwt = tokenJwt;
    }
}
