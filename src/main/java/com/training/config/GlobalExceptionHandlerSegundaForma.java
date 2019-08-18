package com.training.config;

import com.training.model.error.dto.ErrorDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * a diferença entre essa e a primeira handle é que essa extends essa classe que tem alguns metodos
 * prontos
 */
@ControllerAdvice
public class GlobalExceptionHandlerSegundaForma extends ResponseEntityExceptionHandler
{

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
    {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMensagen("invalido");
        errorDTO.setErrorDev(ex.getCause().toString());
        return handleExceptionInternal(ex, errorDTO,headers, HttpStatus.BAD_REQUEST, request);
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadCredentialsException.class)
    public List<ErrorDTO> badCredencials(BadCredentialsException exception)
    {

        List<ErrorDTO> listErrorDTO = new ArrayList<>();
//        List<FieldError> fieldErrors = exception.getMessage().getFieldErrors();

        String mensagenDeErro = exception.getMessage();
        ErrorDTO dto = new ErrorDTO("exception.getField()", mensagenDeErro);

        listErrorDTO.add(dto);
        return listErrorDTO;
    }

}
