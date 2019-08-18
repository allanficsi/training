package com.training.util.event.listener;

import com.training.util.event.CreateEvent;
import java.net.URI;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class CreateEventListener implements ApplicationListener<CreateEvent>
{
    @Override
    public void onApplicationEvent(CreateEvent createEvent)
    {
        HttpServletResponse response =  createEvent.getResponse();
        Long codigo  = createEvent.getCodigo();

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(codigo).toUri();

        response.setHeader("Location",uri.toASCIIString());
    }
}
