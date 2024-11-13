package kr.co.hanbit.product.management.presentation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> handleConstrainViolatedException(
            ConstraintViolationException ex
    ) {
       Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
       List<String> errors= constraintViolations.stream()
               .map(constraintViolation -> constraintViolation.getPropertyPath() + ", " +
                       constraintViolation.getMessage()
               )
               .toList();

       ErrorMessage errorMessage = new ErrorMessage(errors);
       return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(
            ConstraintViolationException ex
    ) {
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        List<String> errors= constraintViolations.stream()
                .map(constraintViolation -> constraintViolation.getPropertyPath() + ", " +
                        constraintViolation.getMessage()
                )
                .toList();

        ErrorMessage errorMessage = new ErrorMessage(errors);
        return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
    }

}
