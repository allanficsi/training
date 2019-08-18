package com.training.model.error.dto;

public class ErrorDTO
{

    private String mensagen;
    private String campo;
    private String errorDev;

    public ErrorDTO(String mensagen, String campo)
    {
        this.mensagen = mensagen;
        this.campo = campo;
    }

    public ErrorDTO()
    {
    }

    public String getMensagen()
    {
        return mensagen;
    }

    public void setMensagen(String mensagen)
    {
        this.mensagen = mensagen;
    }

    public String getCampo()
    {
        return campo;
    }

    public void setCampo(String campo)
    {
        this.campo = campo;
    }

    public String getErrorDev()
    {
        return errorDev;
    }

    public void setErrorDev(String errorDev)
    {
        this.errorDev = errorDev;
    }
}