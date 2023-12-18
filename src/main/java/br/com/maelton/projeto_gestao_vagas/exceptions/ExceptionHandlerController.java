package br.com.maelton.projeto_gestao_vagas.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Specifies a responsible class for global handling of exceptions
@ControllerAdvice
public class ExceptionHandlerController {
    
    //i'll use the getMessage() method from this variable soon.
    MessageSource messageSource; 

        //Inicializando messageSource via construtor para poder utiliza-la
        //Otherwise it'd assume Null as its value
        public ExceptionHandlerController(MessageSource messageSource) {
            this.messageSource = messageSource;
        }
    
    //Specifies an exception handler method (método tratador de exeções)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorMessageDTO>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        //getBindingResult() returns information about the result of the data binding and validation for a specific form.
        BindingResult exceptionBindingResult = e.getBindingResult();

        //getFieldError() returns the error fields contained in the exception binding results
        List<FieldError> exceptionFieldErrors = exceptionBindingResult.getFieldErrors();

        List<ErrorMessageDTO> errorMessages = new ArrayList<>();

        exceptionFieldErrors.forEach(fieldError -> {
            //getting message arg defined on a validation annotation
            //For example: @Email(message = "Digite um email válido.") 
            String message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());

            ErrorMessageDTO errorMessage = new ErrorMessageDTO(message, fieldError.getField());
            errorMessages.add(errorMessage);
        });

        //ResponseEntity is provided by Spring Boot.
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    } 
}
