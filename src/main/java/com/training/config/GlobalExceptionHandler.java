package com.training.config;

import com.training.model.error.dto.ErrorDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler
{

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorDTO> EntityInvalid(MethodArgumentNotValidException exception)
    {

        List<ErrorDTO> listErrorDTO = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach(error -> {
            String mensagenDeErro = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            ErrorDTO dto = new ErrorDTO( mensagenDeErro,error.getField());

            listErrorDTO.add(dto);
        });

        return listErrorDTO;
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
