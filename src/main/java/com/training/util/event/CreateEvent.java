package com.training.util.event;

import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationEvent;

/**
 * Classe que representa  um evento no spring
 */
public class CreateEvent extends ApplicationEvent
{

    private static final long serialVersionUID = -5724070966619578045L;
    private HttpServletResponse response;
    private Long Codigo;

    public CreateEvent(Object source, HttpServletResponse response, Long codigo)
    {
        super(source);
        this.response = response;
        Codigo = codigo;
    }

    public HttpServletResponse getResponse()
    {
        return response;
    }

    public Long getCodigo()
    {
        return Codigo;
    }
}
