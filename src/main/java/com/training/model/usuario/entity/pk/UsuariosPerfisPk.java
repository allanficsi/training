package com.training.model.usuario.entity.pk;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UsuariosPerfisPk implements Serializable

{

    @Column(name = "CD_USR")
    private   Long codigoUsuario;

    @Column(name = "CD_SGR")
    private  Long codigoPerfil;

    public UsuariosPerfisPk()
    {
    }

    public Long getCodigoUsuario()
    {
        return codigoUsuario;
    }

    public Long getCodigoPerfil()
    {
        return codigoPerfil;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UsuariosPerfisPk that = (UsuariosPerfisPk) o;
        return Objects.equals(codigoUsuario, that.codigoUsuario) &&
                Objects.equals(codigoPerfil, that.codigoPerfil);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(codigoUsuario, codigoPerfil);
    }
}

