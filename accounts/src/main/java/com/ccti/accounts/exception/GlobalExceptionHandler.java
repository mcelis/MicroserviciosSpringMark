package com.ccti.accounts.exception;

import com.ccti.accounts.dto.ErrorResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request
    ){
        Map<String,String> validationErrors = new HashMap<>();
        List<ObjectError> validateErrorList = ex.getBindingResult().getAllErrors();

        for (ObjectError error: validateErrorList){
            String fieldName = ((FieldError)error).getField();
            String valMessage = error.getDefaultMessage();
            validationErrors.put(fieldName,valMessage);
        }

        return new ResponseEntity<>(validationErrors,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGlobalException(
            Exception exception, WebRequest webRequest
    ) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomerAlreadyExists.class)
    public ResponseEntity<ErrorResponseDto>  handlerCustomerAlreadyExists(
            CustomerAlreadyExists exception, WebRequest webRequest
    ){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,exception.getMessage(), LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorResponseDto> handleResponseNotFound(
            ResourceNotFound exception, WebRequest webRequest){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,exception.getMessage(), LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto,HttpStatus.NOT_FOUND);
    }
}
