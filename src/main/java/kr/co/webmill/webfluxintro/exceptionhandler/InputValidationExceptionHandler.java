package kr.co.webmill.webfluxintro.exceptionhandler;

import kr.co.webmill.webfluxintro.dto.InputFailedValidationResponse;
import kr.co.webmill.webfluxintro.exception.InputValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InputValidationExceptionHandler {
    @ExceptionHandler(InputValidationException.class)
    public ResponseEntity<InputFailedValidationResponse> handleException(InputValidationException ex){
        InputFailedValidationResponse response = new InputFailedValidationResponse();
        response.setErrorCode(ex.getErrorCode());
        response.setMessage(ex.getMessage());
        response.setInput(ex.getInput());
        return ResponseEntity.badRequest().body(response);
    }
}
